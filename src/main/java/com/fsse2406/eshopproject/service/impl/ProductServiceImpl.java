package com.fsse2406.eshopproject.service.impl;

import com.fsse2406.eshopproject.data.product.data.response.ProductResponseData;
import com.fsse2406.eshopproject.data.product.entity.ProductEntity;
import com.fsse2406.eshopproject.exception.product.ProductNotFoundException;
import com.fsse2406.eshopproject.repository.ProductRepository;
import com.fsse2406.eshopproject.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;

    }

    @Override
    public List<ProductResponseData> getallProducts(){
        List<ProductResponseData> productResponseDataList = new ArrayList<>();

        for (ProductEntity productEntity: productRepository.findAll()){
            productResponseDataList.add(new ProductResponseData(productEntity));
        }
        return productResponseDataList;
    }

    @Override
    public ProductResponseData getByPid(Integer pid){
        try{
            return new ProductResponseData(getEntityByPid(pid));
        }catch(Exception ex){
            logger.warn("By Product Id"+ex.getMessage());
            throw ex;
        }
    }

    public ProductEntity getEntityByPid(Integer pid){
        return productRepository.findById(pid).orElseThrow(
                ()-> new ProductNotFoundException(pid)
        );
    }
}
