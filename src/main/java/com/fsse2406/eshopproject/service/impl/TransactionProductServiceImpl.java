package com.fsse2406.eshopproject.service.impl;

import com.fsse2406.eshopproject.data.cartitem.CartItemEntity;
import com.fsse2406.eshopproject.data.transaction.entity.TransactionEntity;
import com.fsse2406.eshopproject.data.transaction_product.TransactionProductEntity;
import com.fsse2406.eshopproject.repository.TransactionProductRepository;
import com.fsse2406.eshopproject.service.TransactionProductService;

public class TransactionProductServiceImpl implements TransactionProductService {
    private final TransactionProductRepository transactionProductRepository;

    public TransactionProductServiceImpl(TransactionProductRepository transactionProductRepository) {
        this.transactionProductRepository = transactionProductRepository;
    }

    public TransactionProductEntity createTransactionProduct(TransactionEntity transaction, CartItemEntity cartItemEntity){
        TransactionProductEntity transactionProductEntity = new TransactionProductEntity(transaction,cartItemEntity);
        return transactionProductRepository.save(transactionProductEntity);
    };


}
