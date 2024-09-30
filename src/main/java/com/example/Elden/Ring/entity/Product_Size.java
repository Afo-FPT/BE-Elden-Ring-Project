package com.example.Elden.Ring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Table(name = "Product_Sizes")
public class Product_Size {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String productSizeId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "sizeId")
    ProSize size;
}
