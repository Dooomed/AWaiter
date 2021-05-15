package com.example.awaiter.controller;

import com.example.awaiter.model.Meal;
import com.example.awaiter.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/meal")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping
    public String showMealDesign(Model model) {
        model.addAttribute("meals", mealService.getAll());
        return "meals";
    }

    @GetMapping("/create")
    public String showCreateDesign(Model model){
        model.addAttribute("meal", new Meal());
        return "createMeal";
    }

    @PostMapping("/create")
    public String processCreateDesign(@ModelAttribute("meal") Meal meal){
        mealService.save(meal);
        return "redirect:/meal";
    }
}
