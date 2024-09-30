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

@Table(name = "Order_Products")
public class Order_Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String orderProductId;
    int quantity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "orderId")
    Order order;

}
