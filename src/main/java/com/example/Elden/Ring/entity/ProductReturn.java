package com.example.Elden.Ring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode

@Entity
@Table(name = "product_returns")
public class ProductReturn {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "return_id", nullable = false, unique = true)
    private String returnId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "problem", nullable = false)
    private String problem;

    @Column(name = "returned_date", nullable = false)
    private LocalDate returnedDate;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id") //FK REFERENCES to users table PrimaryKey
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id") //FK REFERENCES to users table PrimaryKey
    private Product product;
}
