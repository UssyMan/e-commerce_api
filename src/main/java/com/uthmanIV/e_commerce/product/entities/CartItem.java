package com.uthmanIV.e_commerce.product.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "cart_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    private int quantity;

    @NotNull
    private BigDecimal unitPrice;

    @NotNull
    private BigDecimal totalPrice = BigDecimal.ZERO;

    public void setTotalPrice() {
        this.totalPrice = new BigDecimal(quantity).multiply(this.unitPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CartItem cartItem = (CartItem) o;
        return getId() != null && Objects.equals(getId(), cartItem.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "cart = " + cart + ", " +
                "product = " + product + ", " +
                "quantity = " + quantity + ", " +
                "unitPrice = " + unitPrice + ", " +
                "totalPrice = " + totalPrice + ")";
    }
}

