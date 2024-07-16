package com.fsse2406.eshopproject.data.user.dto.request;

public class CreatePersonRequestDto {
    private String firebaseUId;
    private String email;

    public CreatePersonRequestDto(CreatePersonRequestDto dto) {
        this.firebaseUId = dto.getFirebaseUId();
        this.email = dto.getEmail();

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
