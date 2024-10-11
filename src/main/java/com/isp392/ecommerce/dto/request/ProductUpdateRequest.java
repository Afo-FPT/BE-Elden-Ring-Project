package com.isp392.ecommerce.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductUpdateRequest {
    @NotNull
    @NotEmpty(message = "BLANKINFO")
    String productName;

    @NotNull
    @NotEmpty(message = "BLANKINFO")
    String productSize;

    String productDescription;

    @NotNull
    @NotEmpty(message = "BLANKINFO")
    String status;
    int inStock;
    float price;

}
