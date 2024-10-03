package com.example.Elden.Ring.Controller;

import com.example.Elden.Ring.DTO.request.ProductRequest;
import com.example.Elden.Ring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create-product")
    String create(@RequestBody ProductRequest request){
        productService.create(request);
        return "product added";
    }


}
