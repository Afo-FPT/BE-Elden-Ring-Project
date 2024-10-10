package com.isp392.ecommerce.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductUpdateRequest {

    String productName;
    String productSize;
    String productDescription;
    String status;
    String image;
    BigDecimal price;
    Integer inStock;
}
