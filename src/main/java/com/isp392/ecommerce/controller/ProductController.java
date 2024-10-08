package com.isp392.ecommerce.controller;

import com.isp392.ecommerce.dto.request.ProductCreateRequest;
import com.isp392.ecommerce.dto.request.ProductUpdateRequest;
import com.isp392.ecommerce.dto.request.UserCreationRequest;
import com.isp392.ecommerce.dto.request.UserUpdateRequest;
import com.isp392.ecommerce.dto.response.ApiResponse;
import com.isp392.ecommerce.entity.Product;
import com.isp392.ecommerce.entity.User;
import com.isp392.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @CrossOrigin

    @PostMapping("/createProduct")
    ApiResponse<Product> create(@RequestBody @Valid ProductCreateRequest productCreateRequest) {
        return ApiResponse.<Product>builder()
                .result(productService.create(productCreateRequest))
                .build();
    }

//    @PutMapping("/{id}")
//    ApiResponse<Product> update(@PathVariable("id") String productId, @RequestBody ProductUpdateRequest productUpdateRequest){
//        return ApiResponse.<Product>builder()
//                .result(productService.update(productUpdateRequest))
//                .build();
    }

//    public User updateUser(@PathVariable("id") String userId, @RequestBody UserUpdateRequest request) {
//        return userService.updateUser(userId, request);
//    }
//}
