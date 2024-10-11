package com.isp392.ecommerce.entity;

import java.util.List;
import java.util.Set;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode

@Entity
@Table(name = "accounts")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "role", unique = true)
    private String role;

    @Column(name = "password")
    private String password;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Blog> blogs;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cartId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Feedback> feedbacks;
}
