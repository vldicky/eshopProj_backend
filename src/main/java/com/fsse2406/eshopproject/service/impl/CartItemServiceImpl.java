package com.fsse2406.eshopproject.service.impl;

import com.fsse2406.eshopproject.data.cartitem.CartItemEntity;
import com.fsse2406.eshopproject.data.cartitem.data.response.CartItemResponseData;
import com.fsse2406.eshopproject.data.product.entity.ProductEntity;
import com.fsse2406.eshopproject.data.user.domainObject.FirebaseUserData;
import com.fsse2406.eshopproject.data.user.entity.UserEntity;
import com.fsse2406.eshopproject.exception.cart.CartItemException;
import com.fsse2406.eshopproject.repository.CartItemRepository;
import com.fsse2406.eshopproject.repository.ProductRepository;
import com.fsse2406.eshopproject.repository.UserRepository;
import com.fsse2406.eshopproject.service.CartItemService;
import com.fsse2406.eshopproject.service.ProductService;
import com.fsse2406.eshopproject.service.UserService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    public static final Logger logger = LoggerFactory.getLogger(CartItemServiceImpl.class);
    private final UserService userService;
    private final ProductService productService;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;


    public CartItemServiceImpl(UserService userService, ProductService productService, CartItemRepository cartItemRepository, ProductRepository productRepository, UserRepository userRepository){
        this.userService = userService;
        this.productService = productService;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public boolean putCartItem(Integer pid, Integer quantity, FirebaseUserData firebaseUserData){
        try{
            UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
            ProductEntity productEntity = productService.getEntityByPid(pid);

            Optional<CartItemEntity> optionalCartItemEntity = cartItemRepository.findByProductAndUser(productEntity, userEntity);
            if(optionalCartItemEntity.isEmpty()){
                validateQuantity(quantity, productEntity.getStock());
                cartItemRepository.save(new CartItemEntity(productEntity, userEntity, quantity));
            }else{
                CartItemEntity cartItemEntity = optionalCartItemEntity.get(); // get the optionalCart ref address cartItemEntity
                cartItemEntity.setQuantity(cartItemEntity.getQuantity()+ quantity); //cartItemEntity reference quantity + request quantity
                validateQuantity(cartItemEntity.getQuantity(), productEntity.getStock());
            }
        }catch(Exception ex){
            logger.warn("Put User Cart failed"+ex.getMessage());
            throw ex;
        }
        return true;
    }

    @Override
    public List<CartItemResponseData> getUserCart(FirebaseUserData firebaseUserData){
        UserEntity loginUser = userService.getEntityByFirebaseUserData(firebaseUserData);
        List<CartItemResponseData> cartItemResponseDataList = new ArrayList<>();
        for(CartItemEntity cartItemEntity: cartItemRepository.findAllByUser(loginUser)){
            cartItemResponseDataList.add(new CartItemResponseData(cartItemEntity));
        };
        return cartItemResponseDataList;
    }

    @Override
    public CartItemResponseData updateCart(Integer pid, Integer quantity, FirebaseUserData firebaseUserData){ //CartItemResponseData no need updateCartItemResponse as there are cart show **quantity with relevant pid only
        try {
            UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
            ProductEntity productEntity = productService.getEntityByPid(pid);

            CartItemEntity cartItemEntity = getEntityByProductAndUser(productEntity, userEntity);
            validateQuantity(quantity, productEntity.getStock());
            cartItemEntity.setQuantity(quantity);
//            cartItemRepository.save(new CartItemEntity(productEntity, userEntity, quantity));

            return new CartItemResponseData(cartItemEntity);

        }catch(Exception ex){
            logger.warn("Update cart failed ", ex.getMessage());
            throw ex;
        }
    }

    @Override
    @Transactional
    public boolean removeCartItem(FirebaseUserData firebaseUserData,Integer pid){ // ==> haven't checked the removal before if -ve status exist and raise Exception
        Integer deleteCount = cartItemRepository.removeByUser_FirebaseUIdAndProduct_Pid(firebaseUserData.getFirebaseUId(),pid);
        if(deleteCount<=0){
            throw new CartItemException("Delete CartItem failed pid= "+ pid);
        }
        return true;
    }

    public List<CartItemEntity> getEntityListByUser(UserEntity userEntity){

        List<CartItemEntity> cartItemEntityList = cartItemRepository.findAllByUser(userEntity);

        return cartItemEntityList;
    }




    public CartItemEntity getEntityByProductAndUser(ProductEntity productEntity, UserEntity userEntity){
        return cartItemRepository.findByProductAndUser(productEntity, userEntity).orElseThrow(
                ()-> new CartItemException("Cart Item Not Found: "+productEntity.getPid()+", "+userEntity.getUid())
        );
    }

    public void validateQuantity(Integer quantity, Integer stock){
        if(quantity > stock){
            throw new CartItemException(
                    String.format("Quantity should not more than stock quantity-%d, stock-%d", quantity, stock));
        }
    }

    @Override
    public void emptyUserCart(String firebaseUId){
        cartItemRepository.deleteAllByUser_FirebaseUId(firebaseUId);
    }

}
