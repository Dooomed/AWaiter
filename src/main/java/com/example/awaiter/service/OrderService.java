package com.example.awaiter.service;

import com.example.awaiter.model.Order;
import com.example.awaiter.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {

    private final OrderMealService orderMealService;
    private final OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public void update(Order order) {
        orderRepository.save(order);
    }

    public Order findById(Long id) {
        return orderRepository.findOrderById(id);
    }

    public void delete(Long id) {
        orderMealService.deleteMealByOrder(id);
        orderRepository.deleteById(id);}
}
