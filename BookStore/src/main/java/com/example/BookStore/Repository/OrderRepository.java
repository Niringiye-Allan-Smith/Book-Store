package com.example.BookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.Models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Custom methods, e.g., findByCustomer(Customer customer);
}