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

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_size")
    private ProSize proSize;

    @Column(name = "quantity")
    private Integer quantity;
}
