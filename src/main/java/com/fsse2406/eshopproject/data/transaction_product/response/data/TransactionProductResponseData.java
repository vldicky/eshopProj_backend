package com.fsse2406.eshopproject.data.transaction_product.response.data;

import com.fsse2406.eshopproject.data.transaction_product.TransactionProductEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionProductResponseData {
    private Integer tpid;
    private Integer pid;
    private String productname;
    private String description;
    private String image_url;
    private BigDecimal price;
    private int stock;
    private int quantity;

    public TransactionProductResponseData(TransactionProductEntity entity) {
        this.tpid = entity.getTpid();
//        this.transaction = new TransactionProductResponseData(entity.getTransaction()); //No need to keep transaction status(id) as will keep loop and cause stackoverflow
        this.pid = entity.getPid();
        this.productname = entity.getProductname();
        this.description = entity.getDescription();
        this.image_url = entity.getImage_url();
        this.price = entity.getPrice();
        this.stock = entity.getStock();
        this.quantity = entity.getQuantity();
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
