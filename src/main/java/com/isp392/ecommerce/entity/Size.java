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

    private String name;

    @OneToMany(mappedBy = "size", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductVariant> productSizes;
}
