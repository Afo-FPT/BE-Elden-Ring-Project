package com.isp392.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @Column(name = "cartItemId", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    String cartItemId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartd")
    Cart cart;

    @JsonIgnoreProperties({"cartItems"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    Product product;

    @Column(name = "quantity", nullable = false)
    int quantity;
}

