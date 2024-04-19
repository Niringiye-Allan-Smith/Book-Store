package com.example.BookStore.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookStore.Models.Book;
import com.example.BookStore.Models.Category;
import com.example.BookStore.Repository.AuthorRepository;
import com.example.BookStore.Repository.BookRepository;
import com.example.BookStore.Repository.CategoryRepository;
import com.example.BookStore.Repository.PublisherRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
        private AuthorRepository authorRepository;
            private PublisherRepository publisherRepository;

            private CategoryRepository categoryRepository;


    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

   public Book saveBook(Book book) {
        // Set related entities before saving
        if (book.getAuthor() != null) {
            book.setAuthor(authorRepository.findById(book.getAuthor().getId()).orElse(null));
        }
        if (book.getPublisher() != null) {
            book.setPublisher(publisherRepository.findById(book.getPublisher().getId()).orElse(null));
        }
        if (book.getCategories() != null) {
            Set<Category> categories = new HashSet<>();
            for (Category category : book.getCategories()) {
                categories.add(categoryRepository.findById(category.getId()).orElse(null));
            }
            book.setCategories(categories);
        }
        return bookRepository.save(book);
    }
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}