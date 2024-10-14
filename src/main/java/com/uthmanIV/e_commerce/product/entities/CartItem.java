package com.uthmanIV.e_commerce.product.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice = BigDecimal.ZERO;

    public void setTotalPrice() {
        this.totalPrice = new BigDecimal(quantity).multiply(this.unitPrice);
    }
}

