package com.example.awaiter.service;

import com.example.awaiter.model.Orders;
import com.example.awaiter.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Orders save(Orders orders) {
        return orderRepository.save(orders);
    }

    public List<Orders> getAll() {
        return orderRepository.findAll();
    }
}
