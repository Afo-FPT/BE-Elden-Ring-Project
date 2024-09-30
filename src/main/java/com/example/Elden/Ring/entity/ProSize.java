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

@Table(name = "ProSizes")
public class ProSize {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String sizeId;

    String size;
    @JsonManagedReference
    @OneToMany(mappedBy = "size", cascade = CascadeType.ALL)
    List<Product_Size> product_size;

}
