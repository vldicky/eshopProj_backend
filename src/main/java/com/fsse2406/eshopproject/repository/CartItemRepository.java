package com.fsse2406.eshopproject.repository;

import com.fsse2406.eshopproject.data.cartitem.CartItemEntity;
import com.fsse2406.eshopproject.data.product.entity.ProductEntity;
import com.fsse2406.eshopproject.data.user.domainObject.FirebaseUserData;
import com.fsse2406.eshopproject.data.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends CrudRepository<CartItemEntity, Integer>{
    Optional<CartItemEntity> findByProductAndUser(ProductEntity product, UserEntity user);

    List<CartItemEntity> findAllByUser(UserEntity userEntity);
    Integer removeByUser_FirebaseUIdAndProduct_Pid(String firebaseUId, Integer pid);   // missed to checking the removal Product pid_user in task 6
    void deleteAllByUser_FirebaseUId(String firebaseUId);
}