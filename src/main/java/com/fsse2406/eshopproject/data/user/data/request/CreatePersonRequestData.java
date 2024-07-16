package com.fsse2406.eshopproject.data.user.data.request;

import com.fsse2406.eshopproject.data.user.dto.request.CreatePersonRequestDto;

public class CreatePersonRequestData {
    private String firebaseUId;
    private String email;

    public CreatePersonRequestData(CreatePersonRequestDto dto) {
        this.firebaseUId = dto.getFirebaseUId();
        this.email = dto.getEmail();
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
