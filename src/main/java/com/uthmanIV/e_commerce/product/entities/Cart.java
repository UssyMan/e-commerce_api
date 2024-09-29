package com.uthmanIV.e_commerce.product.entities;

import com.uthmanIV.e_commerce.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "carts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Order order;

    @Column(name = "amount")
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;


}

