package com.fsse2406.eshopproject.data.transaction.data.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fsse2406.eshopproject.data.transaction.Status;
import com.fsse2406.eshopproject.data.transaction.entity.TransactionEntity;
import com.fsse2406.eshopproject.data.transaction_product.TransactionProductEntity;
import com.fsse2406.eshopproject.data.transaction_product.response.data.TransactionProductResponseData;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"tid","buyer_uid","datetime","status","total","items"})
public class TransactionResponseData {
    private Integer tid;
    @JsonProperty("buyer_uid")
    private Integer uid;
    @JsonFormat(pattern="yyyyMMdd'T'HH:mm:ss")
    private LocalDateTime transactDate;

    private Status result;
    private BigDecimal total;

    List<TransactionProductResponseData> transactionProductEntityList = new ArrayList<>();

    public TransactionResponseData(TransactionEntity entity) {
        this.tid = entity.getTid();
        this.uid = entity.getUser().getUid();
        this.transactDate = entity.getTransactDate();
        this.total = entity.getTotal();
        this.result = entity.getResult();
        setTransactionProductEntityList(entity);
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public void setTransactionProductEntityList(List<TransactionProductResponseData> transactionProductEntityList) {
        this.transactionProductEntityList = transactionProductEntityList;
    }

    public void setTransactionProductEntityList(TransactionEntity entity){
        for(TransactionProductEntity transactionProductEntity: entity.getTransactionProductEntityList()){
            this.transactionProductEntityList.add(new TransactionProductResponseData(transactionProductEntity));
        }
    }
}
