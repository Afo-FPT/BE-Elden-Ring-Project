package com.example.Elden.Ring.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String productId;
    private String productName;
    private String description;
    private Double price;
    private String status;
    private Integer stock;
}
