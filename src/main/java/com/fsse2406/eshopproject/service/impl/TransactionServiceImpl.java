package com.fsse2406.eshopproject.service.impl;

import com.fsse2406.eshopproject.data.cartitem.CartItemEntity;
import com.fsse2406.eshopproject.data.transaction.Status;
import com.fsse2406.eshopproject.data.transaction.data.response.TransactionResponseData;
import com.fsse2406.eshopproject.data.transaction.entity.TransactionEntity;
import com.fsse2406.eshopproject.data.transaction_product.TransactionProductEntity;
import com.fsse2406.eshopproject.data.transaction_product.response.data.TransactionProductResponseData;
import com.fsse2406.eshopproject.data.user.domainObject.FirebaseUserData;
import com.fsse2406.eshopproject.data.user.entity.UserEntity;
import com.fsse2406.eshopproject.exception.cart.CartItemException;
import com.fsse2406.eshopproject.exception.transaction.PrepareTransactionException;
import com.fsse2406.eshopproject.exception.transaction.TransactionNotFoundException;
import com.fsse2406.eshopproject.repository.CartItemRepository;
import com.fsse2406.eshopproject.repository.TransactionProductRepository;
import com.fsse2406.eshopproject.repository.TransactionRepository;
import com.fsse2406.eshopproject.repository.UserRepository;
import com.fsse2406.eshopproject.service.CartItemService;
import com.fsse2406.eshopproject.service.TransactionProductService;
import com.fsse2406.eshopproject.service.TransactionService;
import com.fsse2406.eshopproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    public static Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
    private final TransactionRepository transactionRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;
    private final CartItemService cartItemService;
    private final TransactionProductService transactionProductService;
    private final TransactionProductRepository transactionProductRepository;


    public TransactionServiceImpl(TransactionProductRepository transactionProductRepository,UserService userService, UserRepository userRepository, CartItemRepository cartItemRepository, CartItemService cartItemService, TransactionRepository transactionRepository, TransactionProductService transactionProductService) {
        this.transactionRepository = transactionRepository;
        this.cartItemRepository = cartItemRepository;
        this.userService = userService;
        this.transactionProductService = transactionProductService;
        this.userRepository = userRepository;
        this.cartItemService = cartItemService;
        this.transactionProductRepository = transactionProductRepository;
    }

    @Override
    public TransactionResponseData createprepareTransaction(FirebaseUserData firebaseUserData) {
        try {
            UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
            List<CartItemEntity> userCart = cartItemService.getEntityListByUser(userEntity);
            if(userCart.isEmpty()){ //UserCart need to define first
                throw new PrepareTransactionException("Cart is empty & not found!");
            }
            TransactionEntity transactionEntity = new TransactionEntity(userEntity); //transactionService.getEntityByTid(Integer tid);
            transactionEntity = transactionRepository.save(transactionEntity);

            List<TransactionProductEntity> transactionProductEntityList = new ArrayList<>();
            BigDecimal total = BigDecimal.ZERO;
            for(CartItemEntity cartItemEntity: userCart){
                TransactionProductEntity transactionProductEntity = transactionProductService.createTransactionProduct(transactionEntity, cartItemEntity);
                transactionProductEntityList.add(transactionProductEntity);
                total = total.add(
                        transactionProductEntity.getPrice().multiply(new BigDecimal(transactionProductEntity.getQuantity())
                        )
                );
            }
            transactionEntity.setTotal(total);
//            transactionEntity = transactionRepository.findById(transactionEntity.getTid()).get();
            transactionEntity = transactionRepository.save(transactionEntity);
            return new TransactionResponseData(transactionEntity,transactionProductEntityList);

        }catch(Exception ex){
            logger.warn("Prepare Transaction "+ex.getMessage());
            throw ex;
        }
    }

    @Override
    public TransactionResponseData getTransactById(FirebaseUserData firebaseUserData, Integer tid){
        try{
            TransactionEntity transactionEntity = getEntityByTransactAndUser(tid,firebaseUserData);   //check Transaction & FirebaseUserData entry first need auth
            List<TransactionProductEntity> transactionProductEntityList = transactionProductService.getEntityListByTransaction(transactionEntity);
            return new TransactionResponseData(transactionEntity,transactionProductEntityList);

        }catch(Exception ex){
            logger.warn("Search By Transaction Id"+ex.getMessage());
            throw ex;
        }
    }

    @Override
    public boolean updateTransaction(FirebaseUserData firebaseUserData, Integer tid){   //check entitylist by Transaction & FirebaseUserData (same missing in
        try {
            TransactionEntity transactionEntity = getEntityByTransactAndUser(tid,firebaseUserData);
            if (transactionEntity.getResult() != Status.Preparing) {
                transactionEntity.getTid();
            }
            if (!transactionEntity.getTid().equals(tid)) {
                throw new TransactionNotFoundException("Transaction Not Found");
            } else {
                transactionEntity.setResult(Status.Processing);
                return true;
            }

        }catch(Exception ex){
            logger.warn("Update transaction status failed ", ex.getMessage());
            throw ex;
        }

    }

    public TransactionEntity getEntityByTransactAndUser(Integer tid, FirebaseUserData firebaseUserData){
        return transactionRepository.findByTidAndUserFirebaseUId(tid,firebaseUserData).orElseThrow(
                ()-> new TransactionNotFoundException("Transaction Not Found: "+tid+","+firebaseUserData.getFirebaseUId())
        );
    }

    public TransactionResponseData finishTransaction (FirebaseUserData firebaseUserData, Integer tid){
        return null;
    }
}
