package com.example.Elden.Ring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

@Table(name= "Cart_Products")
public class Cart_Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String cartproductid;
    int quantity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cartId")
    Cart cart;


}
