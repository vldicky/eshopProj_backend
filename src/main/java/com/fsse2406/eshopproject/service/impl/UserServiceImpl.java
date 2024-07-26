package com.fsse2406.eshopproject.service.impl;

import com.fsse2406.eshopproject.data.user.domainObject.FirebaseUserData;
import com.fsse2406.eshopproject.data.user.entity.UserEntity;
import com.fsse2406.eshopproject.repository.UserRepository;
import com.fsse2406.eshopproject.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getEntityByFirebaseUserData(FirebaseUserData firebaseUserData){
        Optional<UserEntity> optionalUserEntity = userRepository.findByFirebaseUId(firebaseUserData.getFirebaseUId());
        if(optionalUserEntity.isEmpty()){
            UserEntity userEntity = new UserEntity(firebaseUserData);
            return userRepository.save(userEntity);
        }else{
            return optionalUserEntity.get();
        }
//     Lv3
//        return uerRespository.findByFirebaseUid(firebaseUserData.getFirebaseUId()).orElseGet(
//                ()->userRepository.save(new UserEntity(firebaseUserData))
//        );
    }
}
