package com.fsse2406.eshopproject.data.transaction.entity;

import com.fsse2406.eshopproject.data.cartitem.CartItemEntity;
import com.fsse2406.eshopproject.data.transaction.Status;
import com.fsse2406.eshopproject.data.transaction_product.TransactionProductEntity;
import com.fsse2406.eshopproject.data.user.entity.UserEntity;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    @ManyToOne
    @JoinColumn(name = "buyer_uid", nullable=false) //when mapping multiple properties to the same column
    private UserEntity user;

    @Column(name ="datetime",nullable = false)
    private LocalDateTime transactDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status result;
    @Column(nullable = false)
    private BigDecimal total;


    @OneToMany (mappedBy = "transaction")
    List<TransactionProductEntity> transactionProductEntityList;

    public TransactionEntity(){

    }

    public TransactionEntity(UserEntity user) {
        this.user = user;
        this.transactDate = LocalDateTime.now();
        this.total = BigDecimal.ZERO;
        this.result = Status.Preparing;
        this.transactionProductEntityList = transactionProductEntityList;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public LocalDateTime getTransactDate() {
        return transactDate;
    }

    public void setTransactDate(LocalDateTime transactDate) {
        this.transactDate = transactDate;
    }

    public Status getResult() {
        return result;
    }

    public void setResult(Status result) {
        this.result = result;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<TransactionProductEntity> getTransactionProductEntityList() {
        return transactionProductEntityList;
    }

    public void setTransactionProductEntityList(List<TransactionProductEntity> transactionProductEntityList) {
        this.transactionProductEntityList = transactionProductEntityList;
    }

}
