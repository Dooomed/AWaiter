package com.example.awaiter.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "orders")
@Data
@Entity
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="mealList")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;

    private int tableNumber;

    @OneToMany(mappedBy = "pk.order")
    private List<MealInOrder> mealList= new ArrayList<>();

    @Transient
    public int getAmountOfProducts() {
        return this.mealList.size();
    }
}
