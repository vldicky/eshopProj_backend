package com.fsse2406.eshopproject.exception.product;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Integer pid){
        super("Product not found "+pid);
    };
}
