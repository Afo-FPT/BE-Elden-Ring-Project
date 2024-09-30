package com.example.Elden.Ring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String productId;

    String productName;
    String description;
    Double price;
    String productImage;
    String status;
    Integer stock;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<Order_Product> Order_Products;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cateId")
    Category category;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<Product_Size> Product_Size;


}
