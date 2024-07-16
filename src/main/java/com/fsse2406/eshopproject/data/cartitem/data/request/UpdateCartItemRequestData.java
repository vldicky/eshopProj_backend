package com.fsse2406.eshopproject.data.cartitem.data.request;

import com.fsse2406.eshopproject.data.cartitem.dto.UpdateCartItemRequestDto;
import com.fsse2406.eshopproject.data.product.entity.ProductEntity;
import com.fsse2406.eshopproject.data.user.entity.UserEntity;

public class UpdateCartItemRequestData {
    private Integer cid;
    private ProductEntity product;
    private UserEntity user;
    private Integer quantity;

    public UpdateCartItemRequestData(UpdateCartItemRequestDto dto) {
        this.cid = dto.getCid();
        this.product = dto.getProduct();
        this.user = dto.getUser();
        this.quantity = dto.getQuantity();
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
