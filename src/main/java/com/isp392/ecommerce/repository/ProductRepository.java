package com.isp392.ecommerce.repository;

import com.isp392.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    public Product findByProductName(String productName);
    boolean existsByProductName(String productName);

}
