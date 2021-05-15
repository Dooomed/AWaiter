package com.example.awaiter.service;

import com.example.awaiter.model.Meal;
import com.example.awaiter.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepo;

    public Meal save(Meal meal) {
        return mealRepo.save(meal);
    }

    public List<Meal> getAll() {
        return mealRepo.findAll();
    }
}
