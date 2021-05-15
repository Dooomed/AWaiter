package com.example.awaiter.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int tableNumber;

    @ManyToMany(targetEntity = Meal.class)
    private List<Meal> mealList;

    public void addMeal(Meal meal) {
        this.mealList.add(meal);
    }
}
