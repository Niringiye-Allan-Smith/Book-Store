package com.example.bookstore.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.Models.Author;

public interface AuthorRepository extends JpaRepository<Author,Long>{
    
}
