package com.fsse2406.eshopproject.data.cartitem.dto.response;

import com.fsse2406.eshopproject.data.cartitem.data.response.CartItemResponseData;
import com.fsse2406.eshopproject.data.product.entity.ProductEntity;
import com.fsse2406.eshopproject.data.user.entity.UserEntity;

import java.math.BigDecimal;

public class CartItemResponseDto {
    private Integer pid;
    private String productName;
    private String imageUrl;
    private BigDecimal price;
    private Integer quantity;
    private Integer stock;

    public CartItemResponseDto(CartItemResponseData data) {
        this.pid = data.getProduct().getPid();
        this.productName = data.getProduct().getProductname();
        this.imageUrl = data.getProduct().getImage_url();
        this.price = data.getProduct().getPrice();
        this.quantity = data.getQuantity();
        this.stock = data.getProduct().getStock();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
