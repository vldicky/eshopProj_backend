package com.fsse2406.eshopproject.repository;

import com.fsse2406.eshopproject.data.cartitem.CartItemEntity;
import com.fsse2406.eshopproject.data.product.entity.ProductEntity;
import com.fsse2406.eshopproject.data.transaction.entity.TransactionEntity;
import com.fsse2406.eshopproject.data.transaction_product.TransactionProductEntity;
import com.fsse2406.eshopproject.data.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TransactionProductRepository extends CrudRepository<TransactionProductEntity,Integer> {
    Optional<TransactionProductEntity> findByTransactAndUser(TransactionEntity transaction, UserEntity user);
}
