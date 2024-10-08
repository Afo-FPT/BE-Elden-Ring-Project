package com.isp392.ecommerce.service;

import com.isp392.ecommerce.dto.request.ProductCreateRequest;
import com.isp392.ecommerce.dto.request.ProductUpdateRequest;
import com.isp392.ecommerce.dto.request.UserCreationRequest;
import com.isp392.ecommerce.entity.Product;
import com.isp392.ecommerce.entity.User;
import com.isp392.ecommerce.exception.AppException;
import com.isp392.ecommerce.exception.ErrorCode;
import com.isp392.ecommerce.mapper.ProductMapper;
import com.isp392.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public Product create(ProductCreateRequest productCreateRequest) {

        Product product = productMapper.toproduct(productCreateRequest);

        return productRepository.save(product);
    }

//    public Product update(String productId,ProductUpdateRequest productUpdateRequest){
//
//    }

}
