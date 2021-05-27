package com.example.awaiter.repository;

import com.example.awaiter.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal,Long> {

    Meal findMealById(Long id);
}
