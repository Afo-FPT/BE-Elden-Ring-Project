package com.isp392.ecommerce.service;

import com.isp392.ecommerce.dto.request.ProductCreateRequest;
import com.isp392.ecommerce.dto.request.ProductUpdateRequest;
import com.isp392.ecommerce.dto.response.ProductResponse;
import com.isp392.ecommerce.entity.Product;
import com.isp392.ecommerce.entity.User;
import com.isp392.ecommerce.exception.AppException;
import com.isp392.ecommerce.exception.ErrorCode;
import com.isp392.ecommerce.mapper.ProductMapper;
import com.isp392.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public ProductResponse create(ProductCreateRequest productCreateRequest) {

        Product product = productMapper.toproduct(productCreateRequest);
        productRepository.save(product);
        return productMapper.toProductResponse(product);
    }

    public ProductResponse update(String productId,ProductUpdateRequest request){
        Product product = productRepository.findById(productId).orElseThrow(() -> new AppException(ErrorCode.PHONEEXISTED));

        productMapper.updateProduct(product, request);


        return productMapper.toProductResponse(productRepository.save(product));
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {// findById() return Optional DType
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }

}
