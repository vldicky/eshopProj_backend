package com.fsse2406.eshopproject.data.user.entity;

import com.fsse2406.eshopproject.data.transaction.entity.TransactionEntity;
import com.fsse2406.eshopproject.data.user.domainObject.FirebaseUserData;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    @Column (name ="firebase_uid", unique = true, nullable=false)
    private String firebaseUId;
    @Column (unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<TransactionEntity> transaction = new ArrayList<>();

    public UserEntity(){

    }

    public UserEntity(FirebaseUserData firebaseUserData){
        this.firebaseUId = firebaseUserData.getFirebaseUId();
        this.email = firebaseUserData.getEmail();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public List<TransactionEntity> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<TransactionEntity> transaction) {
        this.transaction = transaction;
    }
}
