package com.fsse2406.eshopproject.data.transaction.data.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2406.eshopproject.data.transaction.Status;
import com.fsse2406.eshopproject.data.transaction.entity.TransactionEntity;
import com.fsse2406.eshopproject.data.transaction_product.TransactionProductEntity;
import com.fsse2406.eshopproject.data.transaction_product.response.data.TransactionProductResponseData;
import com.fsse2406.eshopproject.data.user.domainObject.UserResponseData;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionResponseData {

    private Integer tid;
    @JsonProperty("buyer_uid")
    private UserResponseData user;

    @JsonFormat(pattern="yyyyMMdd'T'HH:mm:ss")
    private LocalDateTime transactDate;

    private Status result;

    private BigDecimal total;

    List<TransactionProductResponseData> transactionProductEntityList = new ArrayList<>();

    public TransactionResponseData(TransactionEntity entity, List<TransactionProductEntity> transactionProductEntityList) {
        this.tid = entity.getTid();
        this.user = new UserResponseData(entity.getUser());
        this.transactDate = entity.getTransactDate();
        this.total = entity.getTotal();
        this.result = entity.getResult();
        setTransactionProductEntityList(transactionProductEntityList);
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public UserResponseData getUser() {
        return user;
    }

    public void setUser(UserResponseData user) {
        this.user = user;
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

    public List<TransactionProductResponseData> getTransactionProductEntityList() {
        return transactionProductEntityList;
    }

//    public void setTransactionProductEntityList(List<TransactionProductResponseData> transactionProductEntityList) {
//        this.transactionProductEntityList = transactionProductEntityList;
//    }

    public void setTransactionProductEntityList(List<TransactionProductEntity> entityList){
        for(TransactionProductEntity transactionProductEntity: entityList){
            this.transactionProductEntityList.add(new TransactionProductResponseData(transactionProductEntity));
        }
    }
}
