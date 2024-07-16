package com.fsse2406.eshopproject.data.product.entity;

import com.fsse2406.eshopproject.data.product.data.request.CreateProductRequestData;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    @Column(name ="product_name",nullable=false)
    private String productname;
    @Column(name ="product_description",length =500)
    private String description;
    @Column(name ="image_url")
    private String image_url;
    @Column(name ="price",nullable=false)
    private BigDecimal price;
    @Column(name ="stock",nullable=false)
    private int stock;

    public ProductEntity(){

    }

    public ProductEntity(CreateProductRequestData data) {
        this.pid = data.getPid();
        this.productname = data.getProductname();
        this.description = data.getDescription();
        this.image_url = data.getImage_url();
        this.price = data.getPrice();
        this.stock = data.getStock();
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
}
