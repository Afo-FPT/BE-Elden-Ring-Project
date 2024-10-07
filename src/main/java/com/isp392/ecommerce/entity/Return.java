package com.isp392.ecommerce.entity;


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
@Table(name = "returns")
public class Return {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "return_id", nullable = false, unique = true)
    private String returnsId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "problem")
    private String problem;

    @Column(name = "returned_date")
    private LocalDate returnedDate;

    @Column(name = "status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
