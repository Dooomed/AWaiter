package com.example.awaiter.controller;

import com.example.awaiter.model.Meal;
import com.example.awaiter.model.Orders;
import com.example.awaiter.service.MealService;
import com.example.awaiter.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;
    private MealService mealService;

    @GetMapping
    public String showOrders(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }

    @GetMapping("/create")
    public String createOrder(Model model){
        List<Meal> mealList = new ArrayList<>();
        model.addAttribute("order", new Orders());
        model.addAttribute("meals", mealService.getAll());
        model.addAttribute("mealsList", mealList);
        return "createOrder";
    }

    @PostMapping("/create")
    public String processCreateOrder(@ModelAttribute("order")Orders order,
                                     @ModelAttribute("mealList")List<Meal> mealList){
        order.setMealList(mealList);
        orderService.save(order);
        return "redirect:/orders";
    }
}
