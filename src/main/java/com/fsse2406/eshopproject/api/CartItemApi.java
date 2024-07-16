package com.fsse2406.eshopproject.api;

import com.fsse2406.eshopproject.data.cartitem.CartItemEntity;
import com.fsse2406.eshopproject.data.cartitem.data.response.CartItemResponseData;
import com.fsse2406.eshopproject.data.cartitem.dto.response.CartItemResponseDto;
import com.fsse2406.eshopproject.data.cartitem.dto.response.SuccessResponseDto;
import com.fsse2406.eshopproject.data.user.domainObject.FirebaseUserData;
import com.fsse2406.eshopproject.exception.cart.CartItemNotFoundException;
import com.fsse2406.eshopproject.repository.CartItemRepository;
import com.fsse2406.eshopproject.repository.ProductRepository;
import com.fsse2406.eshopproject.service.CartItemService;
import com.fsse2406.eshopproject.util.JwtUtil;
import jakarta.validation.constraints.Positive;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartItemApi {
    private final CartItemService cartItemService;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public CartItemApi(CartItemService cartItemService, CartItemRepository cartItemRepository, ProductRepository productRepository){
        this.cartItemService = cartItemService;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    @PutMapping("/{pid}/{quantity}")
    public SuccessResponseDto putCartItem(JwtAuthenticationToken jwt,
                                          @PathVariable Integer pid,
                                          @Positive @PathVariable Integer quantity){

        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwt);
        cartItemService.putCartItem(pid,quantity,firebaseUserData);
        return new SuccessResponseDto();
    }

    @GetMapping
    public List<CartItemResponseDto> getUserCart(JwtAuthenticationToken jwt){
        List<CartItemResponseDto> cartItemResponseDtoList = new ArrayList<>();
        for(CartItemResponseData cartItemResponseData: cartItemService.getUserCart(JwtUtil.getFirebaseUserData(jwt))){
            cartItemResponseDtoList.add(new CartItemResponseDto(cartItemResponseData));
        }
        return cartItemResponseDtoList;
    }

    @PatchMapping("/{pid}/{quantity}")
    public CartItemResponseDto updateCart(JwtAuthenticationToken jwt,
                                           @PathVariable Integer pid,
                                           @Positive @PathVariable Integer quantity){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwt);
        cartItemService.updateCart(pid,quantity, firebaseUserData);
//       Lv2
//        CartItemResponseData cartItemResponseData = cartItemService.updateCart(pid,quantity, firebaseUserData);
//        CartItemResponseDto cartItemResponseDto = new CartItemResponseDto(cartItemResponseData);
        return new CartItemResponseDto(cartItemService.updateCart(pid,quantity, firebaseUserData));
    }

    @PatchMapping("/{pid}")
    public SuccessResponseDto removeCartItem(JwtAuthenticationToken jwt, @PathVariable Integer pid){
        FirebaseUserData firebaseUserData = JwtUtil.getFirebaseUserData(jwt);
        cartItemService.removeCartItem(pid,firebaseUserData);
        return new SuccessResponseDto();
    }

}