package com.fsse2406.eshopproject.service;

import com.fsse2406.eshopproject.data.cartitem.CartItemEntity;
import com.fsse2406.eshopproject.data.cartitem.data.response.CartItemResponseData;
import com.fsse2406.eshopproject.data.cartitem.dto.response.CartItemResponseDto;
import com.fsse2406.eshopproject.data.cartitem.dto.response.SuccessResponseDto;
import com.fsse2406.eshopproject.data.user.domainObject.FirebaseUserData;
import com.fsse2406.eshopproject.data.user.entity.UserEntity;


import java.util.List;

public interface CartItemService {
     boolean putCartItem(Integer pid, Integer quantity, FirebaseUserData firebaseUserData);
     List<CartItemResponseData> getUserCart(FirebaseUserData firebaseUserData);
     List<CartItemEntity> getEntityListByUser(UserEntity userEntity);
     CartItemResponseData updateCart(Integer pid, Integer quantity, FirebaseUserData firebaseUserData);
     boolean removeCartItem(FirebaseUserData firebaseUserData,Integer pid);
     void emptyUserCart(String firebaseUId);
}
