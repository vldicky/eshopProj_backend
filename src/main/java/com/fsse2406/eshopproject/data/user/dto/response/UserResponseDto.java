package com.fsse2406.eshopproject.data.user.dto.response;


import com.fsse2406.eshopproject.data.user.domainObject.FirebaseUserData;

public class UserResponseDto {
    private String firebaseUId;
    private String email;

    public UserResponseDto(FirebaseUserData data) {
        this.firebaseUId = data.getFirebaseUId();
        this.email = data.getEmail();
    }

    public String getFirebaseUId() {
        return firebaseUId;
    }

    public void setFirebaseUId(String firebaseUId) {
        this.firebaseUId = firebaseUId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
