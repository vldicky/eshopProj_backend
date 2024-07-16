package com.fsse2406.eshopproject.data.product.domainObject.response.dto;

import com.fsse2406.eshopproject.data.product.data.response.ProductResponseData;

import java.math.BigDecimal;

public class UpdateProductResponseDto {
    private int pid;
    private String productname;
    private String image_url;
    private BigDecimal price;
    private boolean hasStock;

    public UpdateProductResponseDto(ProductResponseData data) {
        this.pid = data.getPid();
        this.productname = data.getProductname();
        this.image_url = data.getImage_url();
        this.price = data.getPrice();
        this.hasStock = data.getStock()>0;
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

    public boolean isHasStock() {
        return hasStock;
    }

    public void setHasStock(boolean hasStock) {
        this.hasStock = hasStock;
    }
}
