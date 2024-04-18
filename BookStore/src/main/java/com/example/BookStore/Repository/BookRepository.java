package com.example.BookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.Models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // You can define custom methods here, e.g., findByTitleContaining(String title);
}

