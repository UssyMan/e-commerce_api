package com.uthmanIV.e_commerce.customer;

import com.uthmanIV.e_commerce.product.entities.Cart;
import com.uthmanIV.e_commerce.product.entities.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "customer name cannot be empty")
    @Size(min = 3, max = 64)
    private String name;

    @Email
    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "phone number is required")
    @Size(min = 11, max = 11)
    private String phone;

    @NotBlank(message = "address is required")
    private String address;

    @Temporal(TemporalType.DATE)
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @OneToOne
    private Cart cart;

    // Constructors, Getters, Setters, etc.
}

