package com.isp392.ecommerce.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCreationRequest {

    @NotBlank(message = "Product name must not be as full blank")
    @Size(min = 2, max = 20, message = "Product name must be in range [3...20]")
    String productName;

    String productSize;

    @Size(min = 5, message = "Product name must be at least 5 characters")
    String productDescription;
    String status;
    String image;
    BigDecimal price;
    Integer inStock;
}
