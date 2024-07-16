package com.fsse2406.eshopproject.service;


import com.fsse2406.eshopproject.data.user.domainObject.FirebaseUserData;
import com.fsse2406.eshopproject.data.user.entity.UserEntity;

public interface UserService{

    UserEntity getEntityByFirebaseUserData(FirebaseUserData firebaseUserData);

}
