package com.example.awaiter.dto;

import com.example.awaiter.model.Meal;
import lombok.Data;

@Data
public class OrderMealDto {

    private Meal meal;
    private Integer quantity;

}
