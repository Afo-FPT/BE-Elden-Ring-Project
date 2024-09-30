package com.example.Elden.Ring.entity;

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

@Table(name = "Carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String cartId;

    Long userId;
    Double price;

    @JsonManagedReference
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    List<Cart_Product> cartProducts;



}
