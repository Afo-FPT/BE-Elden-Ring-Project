package com.isp392.ecommerce.mapper;

import com.isp392.ecommerce.dto.request.ProductCreateRequest;
import com.isp392.ecommerce.dto.request.ProductUpdateRequest;
import com.isp392.ecommerce.dto.response.ProductResponse;
import com.isp392.ecommerce.dto.response.UserResponse;
import com.isp392.ecommerce.entity.Product;
import com.isp392.ecommerce.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface ProductMapper {
    Product toproduct(ProductCreateRequest productCreateRequest);
    ProductResponse toProductResponse(Product product);
    void updateProduct(@MappingTarget Product product, ProductUpdateRequest request);

}
