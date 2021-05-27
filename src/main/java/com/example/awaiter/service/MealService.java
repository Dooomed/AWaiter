package com.example.awaiter.service;

import com.example.awaiter.model.Meal;
import com.example.awaiter.model.MealInOrder;
import com.example.awaiter.repository.MealRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MealService {

    private OrderMealService mealInOrderService;
    private MealRepository mealRepo;

    public Meal save(Meal meal) {
        return mealRepo.save(meal);
    }

    public List<Meal> getAll() {
        return mealRepo.findAll();
    }

    public Meal findMealById(Long id) {
        return mealRepo.findMealById(id);
    }

    public void deleteMeal(Long id){
        mealInOrderService.deleteMealInOrder(id);
        mealRepo.deleteById(id);
    }
}
