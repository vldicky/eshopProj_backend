package com.fsse2406.eshopproject.data.cartitem.domainObject.response;

import com.fsse2406.eshopproject.data.product.entity.ProductEntity;
import com.fsse2406.eshopproject.data.user.entity.UserEntity;

public class UpdateCartItemResponseDto {
    private Integer cid;
    private ProductEntity product;
    private UserEntity user;
    private Integer quantity;

    public UpdateCartItemResponseDto(UpdateCartItemResponseData data) {
        this.cid = data.getCid();
        this.product = data.getProduct();
        this.user = data.getUser();
        this.quantity = data.getQuantity();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
