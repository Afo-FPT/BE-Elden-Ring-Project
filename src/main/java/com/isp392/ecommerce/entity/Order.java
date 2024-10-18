package com.isp392.ecommerce.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_id", nullable = false, unique = true)
    private String orderId;

    @Column(name = "status", nullable = false, unique = true)
    private String status;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumer_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetail> orderProducts;

}
