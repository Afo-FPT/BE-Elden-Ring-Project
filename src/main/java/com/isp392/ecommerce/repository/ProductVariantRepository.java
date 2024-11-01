package com.isp392.ecommerce.repository;

import com.isp392.ecommerce.entity.ProductVariant;
import com.isp392.ecommerce.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariant, String> {
    Optional<ProductVariant> findBySize(Size size);
}
