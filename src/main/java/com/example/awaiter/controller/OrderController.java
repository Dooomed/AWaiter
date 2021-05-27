package com.example.awaiter.controller;

import com.example.awaiter.dto.OrderMealDto;
import com.example.awaiter.model.MealInOrder;
import com.example.awaiter.model.Order;
import com.example.awaiter.service.MealService;
import com.example.awaiter.service.OrderMealService;
import com.example.awaiter.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MealService mealService;
    private final OrderMealService orderMealService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> list() {
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }


    @PostMapping("/orders")
    public ResponseEntity<Order> processCreateOrder(@RequestBody OrderForm orderForm) throws Exception {
        List<OrderMealDto> formDtos = orderForm.getMealOrders();
        validateMealExistence(formDtos);
        Order order = new Order();
        order = this.orderService.save(order);

        List<MealInOrder> orderMeals = new ArrayList<>();
        for(OrderMealDto dto : formDtos) {
            orderMeals.add(orderMealService.create(new MealInOrder(
                    order, mealService.findMealById(dto.getMeal().getId()), dto.getQuantity()
            )));
            System.out.println(dto.getMeal().toString());
        }

        order.setMealList(orderMeals);
        order.setTableNumber(orderForm.tableNumber);
        order.setStatus(orderForm.status);
        order.getMealList().forEach(e -> System.out.println(e.getMeal().getName()));
        this.orderService.update(order);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    private void validateMealExistence(List<OrderMealDto> orderMeals) throws Exception{
        List<OrderMealDto> list = orderMeals.stream().filter(
                op -> Objects.isNull(mealService.findMealById(op.getMeal().getId()))).collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(list)) new Exception("Not found!!");
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getMealInOrder(@PathVariable("id") Long id){
        Order order = orderService.findById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/orders/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Long id) {
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Data
    @AllArgsConstructor
    public static class OrderForm {

        private List<OrderMealDto> mealList;

        private int tableNumber;

        private String status;

        public List<OrderMealDto> getMealOrders() {
            return this.mealList;
        }


    }
}
