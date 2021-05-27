package com.example.awaiter.service;

import com.example.awaiter.model.MealInOrder;
import com.example.awaiter.repository.OrderMealRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@AllArgsConstructor
public class OrderMealService {

    private final OrderMealRepository orderMealRepo;

    public MealInOrder create(MealInOrder orderMeal) {
        return this.orderMealRepo.save(orderMeal);
    }


    public void deleteMealInOrder(Long id) {
        this.orderMealRepo.deleteMeal(id);
    }

    public void deleteMealByOrder(Long id) {
        this.orderMealRepo.deleteMealByOrder(id);
    }

}
