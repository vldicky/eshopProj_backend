package com.fsse2406.eshopproject.repository;

import com.fsse2406.eshopproject.data.transaction.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity,Integer> {
    Optional<TransactionEntity> findByUser_FirebaseUIdAndTid(String firebaseUId,Integer tid);

}
