package com.isp392.ecommerce.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode

@Entity
@Table(name = "sizes")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "size_id", nullable = false, unique = true)
    private String sizeId;

    @Column(name = "chest")
    private Double chest;

    @Column(name = "hip")
    private Double hip;

    @Column(name = "length")
    private Double length;

    @OneToMany(mappedBy = "size", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product_Size> productSizes;
}
