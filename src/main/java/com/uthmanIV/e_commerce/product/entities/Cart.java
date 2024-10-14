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
@Table(name = "cart")
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
    private BigDecimal totalAmount= BigDecimal.ZERO;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;

    public void updateTotalAmount(BigDecimal lastCartItemTotal){
        totalAmount = totalAmount.add(lastCartItemTotal);
    }
    public void resetTotalOnItemRemoval(BigDecimal removedItemTotal){
        setTotalAmount(totalAmount.subtract(removedItemTotal));
    }
    public void resetTotalOnItemQuantityChange(BigDecimal oldItemTotal, BigDecimal newItemTotal){
        totalAmount = totalAmount.subtract(oldItemTotal).add(newItemTotal);
    }
}

