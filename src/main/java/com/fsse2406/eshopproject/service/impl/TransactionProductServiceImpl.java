package com.fsse2406.eshopproject.service.impl;

import com.fsse2406.eshopproject.data.cartitem.CartItemEntity;
import com.fsse2406.eshopproject.data.transaction.entity.TransactionEntity;
import com.fsse2406.eshopproject.data.transaction_product.TransactionProductEntity;
import com.fsse2406.eshopproject.repository.TransactionProductRepository;
import com.fsse2406.eshopproject.service.TransactionProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionProductServiceImpl implements TransactionProductService {
    private final TransactionProductRepository transactionProductRepository;

    public TransactionProductServiceImpl(TransactionProductRepository transactionProductRepository) {
        this.transactionProductRepository = transactionProductRepository;
    }

    @Override
    public TransactionProductEntity createTransactionProduct(TransactionEntity transaction, CartItemEntity cartItemEntity){
        TransactionProductEntity transactionProductEntity = new TransactionProductEntity(transaction,cartItemEntity);
        return transactionProductRepository.save(transactionProductEntity);
    }

    @Override
    public List<TransactionProductEntity> getEntityListByTransaction(TransactionEntity transactionEntity){
        return transactionProductRepository.findAllByTransaction(transactionEntity);
    }
}
