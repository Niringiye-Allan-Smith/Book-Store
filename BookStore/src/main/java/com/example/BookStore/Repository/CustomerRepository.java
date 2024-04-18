package com.example.BookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.Models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Custom methods, e.g., findByEmail(String email);
}