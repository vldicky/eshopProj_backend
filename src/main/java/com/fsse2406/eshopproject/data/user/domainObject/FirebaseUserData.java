package com.fsse2406.eshopproject.data.user.domainObject;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class FirebaseUserData {
    private String firebaseUId;
    private String email;

    public FirebaseUserData (JwtAuthenticationToken jwt) {
        this.firebaseUId = (String)jwt.getTokenAttributes().get("user_id");
        this.email = (String) jwt.getTokenAttributes().get("email");
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
