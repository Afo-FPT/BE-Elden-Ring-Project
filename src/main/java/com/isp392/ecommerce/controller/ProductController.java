package com.isp392.ecommerce.controller;

import com.isp392.ecommerce.dto.request.ProductCreationRequest;
import com.isp392.ecommerce.dto.request.ProductUpdateRequest;
import com.isp392.ecommerce.dto.response.ProductResponse;
import com.isp392.ecommerce.entity.Product;
import com.isp392.ecommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") String id) {
        return productService.getProductById(id);
    }

    @GetMapping("/{name}")
    public ProductResponse getProductByName(@PathVariable("name") String name) {
        return productService.getProductByName(name);
    }

    @PostMapping
    public Product createNewProduct(@RequestBody ProductCreationRequest request) {
        return productService.createNewProduct(request);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable("id") String id, @RequestBody ProductUpdateRequest request) {
        return productService.updateProduct(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return "Product has been deleted";
    }

}
