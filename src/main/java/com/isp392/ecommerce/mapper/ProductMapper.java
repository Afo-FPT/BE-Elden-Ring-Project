package com.isp392.ecommerce.mapper;

import com.isp392.ecommerce.dto.request.ProductCreationRequest;
import com.isp392.ecommerce.dto.request.ProductUpdateRequest;
import com.isp392.ecommerce.dto.response.ProductResponse;
import com.isp392.ecommerce.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toProductResponse(Product product);

    Product toProduct(ProductCreationRequest request);
    void updateProduct(@MappingTarget Product product, ProductUpdateRequest request);
}
