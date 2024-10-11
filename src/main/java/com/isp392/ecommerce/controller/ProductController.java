package com.isp392.ecommerce.controller;

import com.isp392.ecommerce.dto.request.ProductCreateRequest;
import com.isp392.ecommerce.dto.request.ProductUpdateRequest;
import com.isp392.ecommerce.dto.request.UserCreationRequest;
import com.isp392.ecommerce.dto.request.UserUpdateRequest;
import com.isp392.ecommerce.dto.response.ApiResponse;
import com.isp392.ecommerce.dto.response.ProductResponse;
import com.isp392.ecommerce.entity.Product;
import com.isp392.ecommerce.entity.User;
import com.isp392.ecommerce.repository.ProductRepository;
import com.isp392.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/createProduct")
    ApiResponse<ProductResponse> create(@RequestBody @Valid ProductCreateRequest productCreateRequest) {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.create(productCreateRequest))
                .build();
    }

    @PutMapping("/{id}")
    ApiResponse<ProductResponse> update(@PathVariable("id") String productId, @RequestBody ProductUpdateRequest request) {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.update(productId, request))
                .build();
    }
    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") String productId) {
        return productService.getProductById(productId);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") String productId) {
        productService.deleteProduct(productId);
        return "Product has been deleted";
    }
}


