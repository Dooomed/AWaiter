package com.example.awaiter.controller;

import com.example.awaiter.model.Meal;
import com.example.awaiter.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class MealController {


    private final MealService mealService;

    @GetMapping("/meals")
    public ResponseEntity<List<Meal>> allMeals() {
        return new ResponseEntity<>(mealService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/meals")
    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal){
        mealService.save(meal);
        return new ResponseEntity<>(meal, HttpStatus.CREATED);
    }

    @DeleteMapping("/meals/delete/{id}")
    public ResponseEntity<?> deleteMeal(@PathVariable("id") Long id) {
        mealService.deleteMeal(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/meals/{id}")
    public ResponseEntity<Meal> findMeal(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mealService.findMealById(id), HttpStatus.OK);
    }
}
