package com.fsse2406.eshopproject.service.impl;

import com.fsse2406.eshopproject.data.cartitem.CartItemEntity;
import com.fsse2406.eshopproject.data.cartitem.data.response.CartItemResponseData;
import com.fsse2406.eshopproject.data.product.entity.ProductEntity;
import com.fsse2406.eshopproject.data.transaction.data.response.TransactionResponseData;
import com.fsse2406.eshopproject.data.transaction.entity.TransactionEntity;
import com.fsse2406.eshopproject.data.transaction_product.TransactionProductEntity;
import com.fsse2406.eshopproject.data.user.domainObject.FirebaseUserData;
import com.fsse2406.eshopproject.data.user.entity.UserEntity;
import com.fsse2406.eshopproject.exception.cart.CartItemException;
import com.fsse2406.eshopproject.exception.product.ProductNotFoundException;
import com.fsse2406.eshopproject.exception.transaction.PrepareTransactionException;
import com.fsse2406.eshopproject.exception.transaction.TransactUserCartExistException;
import com.fsse2406.eshopproject.exception.transaction.TransactionNotFoundException;
import com.fsse2406.eshopproject.repository.CartItemRepository;
import com.fsse2406.eshopproject.repository.TransactionProductRepository;
import com.fsse2406.eshopproject.repository.TransactionRepository;
import com.fsse2406.eshopproject.repository.UserRepository;
import com.fsse2406.eshopproject.service.CartItemService;
import com.fsse2406.eshopproject.service.TransactionService;
import com.fsse2406.eshopproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionServiceImpl implements TransactionService {
    public static Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
    private final TransactionRepository transactionRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;
    private final CartItemService cartItemService;
    private final TransactionService transactionService;
    private final TransactionProductServiceImpl transactionProductService;
    private final TransactionProductRepository transactionProductRepository;


    public TransactionServiceImpl(TransactionService transactionService,TransactionProductRepository transactionProductRepository,UserService userService, UserRepository userRepository, CartItemRepository cartItemRepository, CartItemService cartItemService, TransactionRepository transactionRepository, TransactionProductServiceImpl transactionProductService) {
        this.transactionRepository = transactionRepository;
        this.cartItemRepository = cartItemRepository;
        this.userService = userService;
        this.transactionProductService = transactionProductService;
        this.userRepository = userRepository;
        this.cartItemService = cartItemService;
        this.transactionService = transactionService;
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
            for(CartItemEntity cartItemEntity: userCart){
                TransactionProductEntity transactionProductEntity = transactionProductService.createTransactionProduct(transactionEntity, cartItemEntity);
                transactionProductEntityList.add(transactionProductEntity);
                transactionEntity.setTotal(transactionEntity.getTotal().add(
                        transactionProductEntity.getPrice().multiply(new BigDecimal(transactionProductEntity.getQuantity())
                        )
                ));
            }
            transactionEntity = transactionRepository.findById(transactionEntity.getTid()).get();
            transactionEntity = transactionRepository.save(transactionEntity);
            return new TransactionResponseData(transactionEntity);

        }catch(Exception ex){
            logger.warn("Prepare Transaction "+ex.getMessage());
            throw ex;
        }
    }

    @Override
    public TransactionEntity getTransactById(FirebaseUserData firebaseUserData, Integer tid){
        try{
            UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
            List<CartItemEntity> userCart = cartItemService.getEntityListByUser(userEntity);
            if(userCart.isEmpty()){ //UserCart need to define empty or not
                throw new PrepareTransactionException("Cart is empty & not found!");
            }

            Optional<TransactionEntity> optionalTransactionEntity= transactionRepository.findByTid(tid);
            if(optionalTransactionEntity.isEmpty()){
                throw new TransactionNotFoundException("Transaction Not Found");
            }
            return optionalTransactionEntity.get();

        }catch(Exception ex){
            logger.warn("Search By Transaction Id"+ex.getMessage());
            throw ex;
        }
    }

    public void updateTransaction(FirebaseUserData firebaseUserData,Integer tid){
        try {
            UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
            TransactionEntity transactionEntity = transactionService.getEntityByTid(tid);
            TransactionProductEntity transactionProductEntity = getEntityByTransactAndUser(transactionEntity, userEntity);
            for(Optional<TransactionEntity> optionalTransactionEntity: transactionRepository.findAllById(optionalTransactionEntity.getTid()){
                if (!transactionEntity.getTid().equals(tid)) {
                    throw new TransactionNotFoundException("Transaction Not Found");
                } else {
                    transactionEntity.getResult().Processing;
                    return new TransactionResponseData(transactionEntity);
                }
            }
        }catch(Exception ex){
            logger.warn("Update transaction status failed ", ex.getMessage());
            throw ex;
        }

    }

    public TransactionEntity getEntityByTid(Integer tid){
        return transactionRepository.findById(tid).orElseThrow(
                ()-> new ProductNotFoundException(tid)
        );
    }

    public TransactionProductEntity getEntityByTransactAndUser(TransactionEntity transaction, UserEntity userEntity){
        return transactionProductRepository.findByTransactAndUser(transaction, userEntity).orElseThrow(
                ()-> new CartItemException("Transaction Not Found: "+transaction.getTid()+", "+userEntity.getUid())
        );
    }

}
