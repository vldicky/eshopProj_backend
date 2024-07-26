package com.fsse2406.eshopproject.data.transaction.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fsse2406.eshopproject.data.transaction.Status;
import com.fsse2406.eshopproject.data.transaction.data.response.TransactionResponseData;
import com.fsse2406.eshopproject.data.transaction_product.response.data.TransactionProductResponseData;
import com.fsse2406.eshopproject.data.transaction_product.response.dto.TransactionProductResponseDto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"tid","buyer_uid","datetime","status","total","items"})
public class TransactionResponseDto {
    @JsonProperty("tid")
    private Integer tid;

    @JsonProperty("buyer_uid")
    private Integer uid;

    @JsonProperty("datetime")
    @JsonFormat(pattern="yyyyMMdd'T'HH:mm:ss")
    private LocalDateTime transactDate;

    @JsonProperty("status")
    private Status result;

    @JsonProperty("total")
    private BigDecimal total;
    @JsonProperty("items")
    List<TransactionProductResponseDto> items = new ArrayList<>();

    public TransactionResponseDto(TransactionResponseData data) {
        this.tid = data.getTid();
        this.uid = data.getUser().getUid();
        this.transactDate = data.getTransactDate();
        this.total = data.getTotal();
        this.result= data.getResult();
        setItems(data);
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

    public List<TransactionProductResponseDto> getItems() {
        return items;
    }

    public void setItems(List<TransactionProductResponseDto> items){
        this.items = items;
    }
    public void setItems(TransactionResponseData transactionResponseData) {
        for(TransactionProductResponseData item: transactionResponseData.getTransactionProductEntityList()){
            this.items.add(new TransactionProductResponseDto(item));
        }

    }
}
