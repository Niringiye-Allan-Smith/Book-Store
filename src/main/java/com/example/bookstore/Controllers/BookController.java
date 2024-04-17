package com.example.bookstore.Controllers;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.DTOS.Payloads.BookPayload;
import com.example.bookstore.Services.bookService;

@RestController
@RequestMapping("/api/Bookstore")
public class BookController {
    private bookService myBookService;

    @GetMapping("/books")
    public List<BookPayload> getAllBooks() {
        return myBookService.getAllBook() ;
    }
}
