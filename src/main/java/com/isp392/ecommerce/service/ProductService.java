package com.isp392.ecommerce.service;

//import class
import com.isp392.ecommerce.dto.request.ProductCreationRequest;
import com.isp392.ecommerce.dto.request.ProductUpdateRequest;
import com.isp392.ecommerce.dto.response.ProductResponse;
import com.isp392.ecommerce.entity.Product;
import com.isp392.ecommerce.mapper.ProductMapper;
import com.isp392.ecommerce.repository.ProductRepository;
//framework
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//return type
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Autowired
    public ProductMapper productMapper;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //for manager
    public Product getProductById(String id){
        return productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Product not found")
        );
    }

    //for User
    public ProductResponse getProductByName(String name) {
        Product product = productRepository.findByProductName(name);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        return productMapper.toProductResponse(product);
    }

    public Product createNewProduct(ProductCreationRequest request) {
        if (productRepository.existsByProductName(request.getProductName())) {
            throw new RuntimeException("This product name already exists");
        }
        Product product = productMapper.toProduct(request);
        return productRepository.save(product);
    }

    public ProductResponse updateProduct(String id, ProductUpdateRequest request) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Product not found")
        );
        productMapper.updateProduct(product, request);
        return productMapper.toProductResponse(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
