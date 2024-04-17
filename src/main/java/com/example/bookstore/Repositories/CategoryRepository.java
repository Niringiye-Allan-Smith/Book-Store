package com.example.bookstore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.Models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

   
}
