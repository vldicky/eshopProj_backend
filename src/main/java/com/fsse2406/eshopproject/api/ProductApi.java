package com.fsse2406.eshopproject.api;

import com.fsse2406.eshopproject.config.DevConfig;
import com.fsse2406.eshopproject.data.product.domainObject.response.dto.GetAllProductResponseDto;
import com.fsse2406.eshopproject.data.product.dto.response.ProductResponseDto;
import com.fsse2406.eshopproject.data.product.data.response.ProductResponseData;

import com.fsse2406.eshopproject.repository.ProductRepository;
import com.fsse2406.eshopproject.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@CrossOrigin(origins="http://localhost:5173")
@CrossOrigin({DevConfig.DEV_BSE_URL, DevConfig.PROD_BSE_URL})
@RequestMapping("/public/product")
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

    @GetMapping
    public List<GetAllProductResponseDto> getallProducts(){

//        List<ProductResponseData> productResponseDataList = productService.getallProducts();
        List<GetAllProductResponseDto> productResponseDtoList = new ArrayList<>();

        for (ProductResponseData productResponseData: productService.getallProducts()){
//            ProductResponseDto productResponseDto  = new ProductResponseDto(productResponseData);
            productResponseDtoList.add(new GetAllProductResponseDto(productResponseData));
        }
        return productResponseDtoList;
    }

    @GetMapping("/{pid}")
    public ProductResponseDto getByPid(@PathVariable Integer pid){
//   Lv2
//        ProductResponseData productResponseData = productService.getByPid(pid);
//        ProductResponseDto productResponseDto = new ProductResponseDto(productResponseData);
//        return productResponseDto;
//        Lv3
        return new ProductResponseDto(productService.getByPid(pid));
    }

}
