package com.fsse2406.eshopproject.repository;


import com.fsse2406.eshopproject.data.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findByFirebaseUId(String firebaseUId);
//    boolean existsByFirebaseUId(String firebaseUId);
}
