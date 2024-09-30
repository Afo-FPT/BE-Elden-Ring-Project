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

@Table(name = "Blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String blogId;
    @Column(name = "blogImage", columnDefinition ="VARCHAR(MAX)" )
    String blogImage;
    String title;
    String description;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId")
    User user;
}
