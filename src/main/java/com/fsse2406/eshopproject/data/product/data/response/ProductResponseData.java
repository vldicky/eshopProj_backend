package com.fsse2406.eshopproject.data.product.data.response;

import com.fsse2406.eshopproject.data.product.dto.response.ProductResponseDto;
import com.fsse2406.eshopproject.data.product.entity.ProductEntity;

import java.math.BigDecimal;

public class ProductResponseData {
    private int pid;
    private String productname;
    private String description;
    private String image_url;
    private BigDecimal price;
    private int stock;

    public ProductResponseData(ProductEntity entity) {
        this.pid = entity.getPid();
        this.productname = entity.getProductname();
        this.description = entity.getDescription();
        this.image_url = entity.getImage_url();
        this.price = entity.getPrice();
        this.stock = entity.getStock();
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
