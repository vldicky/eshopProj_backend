package com.fsse2406.eshopproject.data.user.domainObject;

import com.fsse2406.eshopproject.data.user.entity.UserEntity;

public class UserResponseData {
    private Integer uid;
    private String email;
    private String firebaseUId;

    public UserResponseData(UserEntity entity) {
        this.uid = entity.getUid();
        this.email = entity.getEmail();
        this.firebaseUId = entity.getFirebaseUId();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirebaseUId() {
        return firebaseUId;
    }

    public void setFirebaseUId(String firebaseUId) {
        this.firebaseUId = firebaseUId;
    }
}
