package com.fsse2406.eshopproject.service;

import com.fsse2406.eshopproject.data.cartitem.CartItemEntity;
import com.fsse2406.eshopproject.data.product.entity.ProductEntity;
import com.fsse2406.eshopproject.data.transaction.data.response.TransactionResponseData;
import com.fsse2406.eshopproject.data.transaction.dto.response.TransactionResponseDto;
import com.fsse2406.eshopproject.data.transaction.entity.TransactionEntity;
import com.fsse2406.eshopproject.data.transaction_product.TransactionProductEntity;
import com.fsse2406.eshopproject.data.user.domainObject.FirebaseUserData;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public interface TransactionService {
    TransactionResponseData createprepareTransaction(FirebaseUserData firebaseUserData);
//    TransactionEntity getEntityByTid(Integer tid);
    TransactionResponseData getTransactById(FirebaseUserData firebaseUserData, Integer tid);
    @Transactional
    boolean payTransaction(FirebaseUserData firebaseUserData, Integer tid);

    TransactionResponseData finishTransaction(FirebaseUserData firebaseUserData, Integer tid);
}