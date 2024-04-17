package com.example.bookstore.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.DTOS.Payloads.BookPayload;
import com.example.bookstore.Models.Book;
import com.example.bookstore.Repositories.BookRepository;
import java.util.*;

@Service
public class bookService {
	@Autowired
	BookRepository bookRepository;

	/*
	 * Getting all books
	 */
	public List<BookPayload> getAllBook() {

		List<BookPayload> books = new ArrayList<>();

		for (Book book : bookRepository.findAll()) {

			BookPayload payload = new BookPayload();

			payload.setId(book.getId());
			payload.setTitle(book.getTitle());
			payload.setIsbn(book.getIsbn());
			payload.setPrice(book.getPrice());
			payload.setAuthor();
		
			books.add(payload);

		}
		return books;
	}

	/*
	 * Creating a book
	 */
// 	public ResponseEntity<?> createBook(bookRequest request) {
// 		if (request.getName() != null) {

// 			Optional<Book> existingBook = request.getId() != null
// 					? bookRepository.findById(request.getId())
// 					: Optional.empty();

// 			if (!existingBook.isPresent() && bookRepository.existsByName(request.getName())) {
// 				return new ResponseEntity<>(new ApiResponse(false, "Book Exists"), HttpStatus.BAD_REQUEST);
// 			}

// 			Book book = existingBook.isPresent() ? existingBook.get()
// 					: new Book();
// 			book.setId(request.getId());
// 			book.setName(request.getName());
// 			book.setShortName(request.getShortName());

// 			Book result = bookRepository.save(book);

// 			if (result != null) {
// 				System.out.println("Book created");
// 				return new ResponseEntity<>(new ApiResponse(true, "Book Created"), HttpStatus.OK);
// 			}

// 		}
// 		System.out.println("Not Created created");
// 		return new ResponseEntity<>(new ApiResponse(false, "Book Not Created"), HttpStatus.BAD_REQUEST);

// 	}

// 	public ResponseEntity<?> deleteBook(bookRequest request) {
// 		if (request.getId() != null) {
// 			try {
// 				bookRepository.deleteById(request.getId());

// 				return new ResponseEntity<>(new ApiResponse(true, "Book Deleted"), HttpStatus.OK);
// 			} catch (Exception e) {
// 				// TODO: handle exception
// 			}

// 		}

// 		return new ResponseEntity<>(new ApiResponse(false, "Book Not Deleted"), HttpStatus.BAD_REQUEST);

// 	}

// 	public ResponseEntity<?> getBookById(Long id) {
// 		Optional<Book> optionalBook = bookRepository.findById(id);
// 		if (!optionalBook.isPresent()) {
// 			return new ResponseEntity<>(new ApiResponse(false, "Book not found with ID: " + id), HttpStatus.NOT_FOUND);
// 		}
// 		Book book = optionalBook.get();
// 		BookPayload bookPayload = new BookPayload();
// 		bookPayload.setId(book.getId());
// 		bookPayload.setName(book.getName());
// 		bookPayload.setShortName(book.getShortName());
// 		return new ResponseEntity<>(bookPayload, HttpStatus.OK);
// 	}
}
