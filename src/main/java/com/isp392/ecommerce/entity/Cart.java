package com.isp392.ecommerce.entity;
import lombok.*;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cart_id", nullable = false, unique = true)
    private String cartId;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @OneToOne(mappedBy = "cartId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cart_Product> cartProducts;
}
