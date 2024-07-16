package com.fsse2406.eshopproject.exception.cart;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CartItemNotFoundException extends RuntimeException{
    public CartItemNotFoundException(Integer pid){
        super("Cart Item not found " + pid);}
}
