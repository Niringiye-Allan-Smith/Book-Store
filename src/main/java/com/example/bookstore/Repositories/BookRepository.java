package com.example.bookstore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.Models.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

  
}
