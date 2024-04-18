package com.example.BookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.Models.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    // Custom methods, e.g., findByName(String name);
}