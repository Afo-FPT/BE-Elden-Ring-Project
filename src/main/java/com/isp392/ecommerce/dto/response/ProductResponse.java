package com.isp392.ecommerce.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    String productId;
    String productName;
    String productSize;
    String productDescription;
    String status;
    int inStock;
    BigDecimal price;
}
