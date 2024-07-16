package com.fsse2406.eshopproject.data.product.dto.response;

import com.fsse2406.eshopproject.data.product.data.response.ProductResponseData;
import com.fsse2406.eshopproject.data.transaction_product.response.data.TransactionProductResponseData;

import java.math.BigDecimal;

public class ProductResponseDto {
    private int pid;
    private String productname;
    private String description;
    private String image_url;
    private BigDecimal price;
    private int stock;


    public ProductResponseDto(ProductResponseData data) {
        this.pid = data.getPid();
        this.productname = data.getProductname();
        this.description = data.getDescription();
        this.image_url = data.getImage_url();
        this.price = data.getPrice();
        this.stock = data.getStock();
    }

    public ProductResponseDto(TransactionProductResponseData data) { //Overreloading method for TransactionProduct
        this.pid = data.getPid();
        this.productname = data.getProductname();
        this.description = data.getDescription();
        this.image_url = data.getImage_url();
        this.price = data.getPrice();
        this.stock = data.getStock();
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
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

}
