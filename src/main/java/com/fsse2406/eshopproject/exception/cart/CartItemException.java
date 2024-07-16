package com.fsse2406.eshopproject.exception.cart;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CartItemException extends RuntimeException{
    public CartItemException(String msg){
        super("Put Cart Item exception ~"+msg);
    }

}
