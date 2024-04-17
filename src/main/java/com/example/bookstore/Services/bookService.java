package com.example.bookstore.Services;

import org.apache.el.stream.Optional;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bookstore.Models.Book;
import com.example.bookstore.Repositories.BookRepository;

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
			payload.setName(book.getName());
			payload.setShortName(book.getShortName());

			books.add(payload);

		}
		return books;
	}

	/*
	 * Creating a book
	 */
	public ResponseEntity<?> createBook(BookRequest request) {
		if (request.getName() != null) {

			Optional<Book> existingAffliation = request.getId() != null
					? bookRepository.findById(request.getId())
					: Optional.empty();

			if (!existingAffliation.isPresent() && bookRepository.existsByName(request.getName())) {
				return new ResponseEntity<>(new ApiResponse(false, "Book Exists"), HttpStatus.BAD_REQUEST);
			}

			Book book = existingBook.isPresent() ? existingBook.get()
					: new Book();
			book.setId(request.getId());
			book.setName(request.getName());
			book.setShortName(request.getShortName());
			
			Book result = bookRepository.save(book);

			if (result != null) {
				System.out.println("Book created");
				return new ResponseEntity<>(new ApiResponse(true, "Book Created"), HttpStatus.OK);
			}

		}
		System.out.println("Not Created created");
		return new ResponseEntity<>(new ApiResponse(false, "Book Not Created"), HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<?> deleteBook(BookRequest request) {
		if (request.getId() != null) {
			try {
				bookRepository.deleteById(request.getId());

				return new ResponseEntity<>(new ApiResponse(true, "Book Deleted"), HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return new ResponseEntity<>(new ApiResponse(false, "Book Not Deleted"), HttpStatus.BAD_REQUEST);

	}
	
	public ResponseEntity<?> getBookById(Long id) {
	    Optional<Book> optionalBook = bookRepository.findById(id);
	    if (!optionalBook.isPresent()) {
	        return new ResponseEntity<>(new ApiResponse(false, "Book not found with ID: " + id), HttpStatus.NOT_FOUND);
	    }
	    Book book = optionalBook.get();
	    BookPayload bookPayload = new AffiliationPayload();
	    bookPayload.setId(book.getId());
	    bookPayload.setName(book.getName());
	    bookPayload.setShortName(book.getShortName());
	    return new ResponseEntity<>(bookPayload, HttpStatus.OK);
	}
}
