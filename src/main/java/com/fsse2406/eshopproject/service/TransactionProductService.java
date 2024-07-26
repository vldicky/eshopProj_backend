package com.fsse2406.eshopproject.service;

import com.fsse2406.eshopproject.data.cartitem.CartItemEntity;
import com.fsse2406.eshopproject.data.transaction.entity.TransactionEntity;
import com.fsse2406.eshopproject.data.transaction_product.TransactionProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionProductService {

    TransactionProductEntity createTransactionProduct(TransactionEntity transactionEntity, CartItemEntity cartItemEntity);
    List<TransactionProductEntity> getEntityListByTransaction(TransactionEntity transactionEntity);
}