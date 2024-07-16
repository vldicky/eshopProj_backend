package com.fsse2406.eshopproject.data.transaction_product.response.dto;
import com.fsse2406.eshopproject.data.product.dto.response.ProductResponseDto;
import com.fsse2406.eshopproject.data.transaction_product.response.data.TransactionProductResponseData;

import java.math.BigDecimal;

public class TransactionProductResponseDto {
    private Integer tpid;
    private ProductResponseDto product;
    private BigDecimal subtotal;
    private Integer quantity;

    public TransactionProductResponseDto(TransactionProductResponseData data) {
        this.tpid = data.getTpid();
        this.product = new ProductResponseDto(data);
        this.subtotal = data.getPrice().multiply(new BigDecimal(data.getQuantity()));
        this.quantity = data.getQuantity();
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public ProductResponseDto getProduct() {
        return product;
    }

    public void setProduct(ProductResponseDto product) {
        this.product = product;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
