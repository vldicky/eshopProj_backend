package com.fsse2406.eshopproject.data.transaction_product;

import com.fsse2406.eshopproject.data.cartitem.CartItemEntity;
import com.fsse2406.eshopproject.data.transaction.entity.TransactionEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transaction_product")
public class TransactionProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tpid;
    @ManyToOne
    @JoinColumn(name = "tid", nullable=false)
    private TransactionEntity transaction;

    @Column
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
    @Column(name = "quantity",nullable = false)
    private Integer quantity;


    public TransactionProductEntity(){

    }
    public TransactionProductEntity(TransactionEntity transaction, CartItemEntity cartItemEntity) {
        this.transaction = transaction;
        this.pid = cartItemEntity.getProduct().getPid();
        this.productname = cartItemEntity.getProduct().getProductname();
        this.description = cartItemEntity.getProduct().getDescription();
        this.image_url = cartItemEntity.getProduct().getImage_url();
        this.price = cartItemEntity.getProduct().getPrice();
        this.stock = cartItemEntity.getProduct().getStock();
        this.quantity = cartItemEntity.getQuantity();

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }
}
