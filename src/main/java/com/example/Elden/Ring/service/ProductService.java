package com.example.Elden.Ring.service;

import com.example.Elden.Ring.DTO.request.ProductRequest;
import com.example.Elden.Ring.entity.Product;
import com.example.Elden.Ring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void create(ProductRequest productRequest){
        Product product = Product.builder()
                .productId(productRequest.getProductId())
                .productName(productRequest.getProductName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .status(productRequest.getStatus())
                .stock(productRequest.getStock())
                .build();
        productRepository.save(product);
    }
}
