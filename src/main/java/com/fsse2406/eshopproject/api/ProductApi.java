package com.fsse2406.eshopproject.api;

import com.fsse2406.eshopproject.data.product.dto.response.ProductResponseDto;
import com.fsse2406.eshopproject.data.product.data.response.ProductResponseData;
import com.fsse2406.eshopproject.data.product.entity.ProductEntity;
import com.fsse2406.eshopproject.repository.ProductRepository;
import com.fsse2406.eshopproject.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductApi {
    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductApi(ProductService productService, ProductRepository productRepository){
        this.productService = productService;
        this.productRepository = productRepository;
    }

//    @PostMapping("/upload")
//    public CreateProductRequestDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
//        CreateProductRequestData createProductRequestData = new CreateProductRequestData(createProductRequestDto);
//        ProductResponseData productResponseData = productService.createProduct(createProductRequestData);
//        ProductResponseDto productResponseDto = new ProductResponseDto(productResponseData);
//        return productResponseDto;
//    }

    @GetMapping("/all")
    public List<ProductResponseDto> getallProducts(){

        List<ProductResponseData> productResponseDataList = productService.getallProducts();
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();

        for (ProductResponseData productResponseData: productResponseDataList){
            ProductResponseDto productResponseDto  = new ProductResponseDto(productResponseData);
            productResponseDtoList.add(new ProductResponseDto(productResponseData));
        }
        return productResponseDtoList;
    }

    @GetMapping("/{id}")
    public ProductResponseDto getByPid(@PathVariable Integer pid){
//   Lv2
//        ProductResponseData productResponseData = productService.getByPid(pid);
//        ProductResponseDto productResponseDto = new ProductResponseDto(productResponseData);
//        return productResponseDto;
//        Lv3
        return new ProductResponseDto(productService.getByPid(pid));
    }

}
