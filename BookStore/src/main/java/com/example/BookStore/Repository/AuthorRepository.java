package com.example.BookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.Models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Custom methods, e.g., findByName(String name);
}