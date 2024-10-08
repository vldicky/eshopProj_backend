package com.fsse2406.eshopproject.repository;

import com.fsse2406.eshopproject.data.cartitem.CartItemEntity;
import com.fsse2406.eshopproject.data.transaction.entity.TransactionEntity;
import com.fsse2406.eshopproject.data.transaction_product.TransactionProductEntity;
import com.fsse2406.eshopproject.data.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionProductRepository extends CrudRepository<TransactionProductEntity,Integer> {

    List<TransactionProductEntity> findAllByTransaction(TransactionEntity transactionEntity);
}
