package com.example.BookStore.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookStore.Models.OrderItem;
import com.example.BookStore.Repository.OrderItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> findAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> findOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}