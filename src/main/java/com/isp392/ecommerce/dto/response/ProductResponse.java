package com.isp392.ecommerce.dto.response;

import com.isp392.ecommerce.dto.request.ProductVariantRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    String productId;
    String name;
    String description;
    Boolean status;
    String image;
    Integer stock;
    Double price;
    String cateName;
    List<ProductVariantResponse> productVariants; // Danh sách các kích thước và số lượng
}
