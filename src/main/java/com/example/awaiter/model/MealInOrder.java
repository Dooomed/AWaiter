package com.example.awaiter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
public class MealInOrder implements Serializable {

    @EmbeddedId
    @JsonIgnore
    private MealOrderPK pk;

    @Column(nullable = false)
    private int quantity;

    public MealInOrder(Order order, Meal meal, Integer quantity) {
        pk = new MealOrderPK();
        pk.setOrder(order);
        pk.setMeal(meal);
        this.quantity = quantity;
    }

    @Transient
    public Meal getMeal() {
        return this.pk.getMeal();
    }

    @Transient
    public BigDecimal getTotalPrice() {
        return getMeal().getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}
