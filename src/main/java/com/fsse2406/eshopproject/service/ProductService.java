package com.fsse2406.eshopproject.service;

import com.fsse2406.eshopproject.data.product.data.request.CreateProductRequestData;
import com.fsse2406.eshopproject.data.product.data.response.ProductResponseData;
import com.fsse2406.eshopproject.data.product.dto.response.ProductResponseDto;
import com.fsse2406.eshopproject.data.product.entity.ProductEntity;


import java.util.List;

public interface ProductService {
    List<ProductResponseData> getallProducts();
    ProductResponseData getByPid(Integer pid);
    ProductEntity getEntityByPid(Integer pid);

    boolean isValidQuantity(Integer quantity, Integer pid);
}
