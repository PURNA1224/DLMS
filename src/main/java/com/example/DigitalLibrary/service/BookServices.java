package com.example.DigitalLibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.DigitalLibrary.dao.BookDao;
import com.example.DigitalLibrary.model.Book;

@Service
public class BookServices {

	@Autowired
	private BookDao bookDao;
	
	public ResponseEntity<String> addBookService(Book book){
		System.out.println(book);
		bookDao.save(book);
		return ResponseEntity.ok("Book Added Successfully");
	}
	
	public ResponseEntity<List<Book>> getBooks(){
		return ResponseEntity.ok(bookDao.findAll());
	}
	
	public ResponseEntity<?> getBookByIdOrTitle(Long bookId, String title){
		if(bookId != null) {
			Book book = bookDao.findById(bookId).orElse(null);
			return (book != null)? ResponseEntity.ok(book) : ResponseEntity.badRequest().body("Book Not Found, provide a valid book id"); 
		}
		
		if(title!= null) {
			Book book = bookDao.findByTitleIgnoreCase(title).orElse(null);
			return (book != null)? ResponseEntity.ok(book) : ResponseEntity.badRequest().body("Book Not Found, provide a valid title") ;
		}
		
		return ResponseEntity.badRequest().body("Please provide either book id or title");
	}

	public ResponseEntity<String> updateBook(Book book){
		return bookDao.findById(book.getBookId()).map(existingBook -> {
			bookDao.updateById(book.getBookId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getAvailability_status());
//			bookDao.save(book);
			return ResponseEntity.ok("Book updated");
		}).orElse(ResponseEntity.badRequest().body("Book doen't exist"));
	}
	
	public ResponseEntity<?> deleteBook(Long bookId){
		if(!bookDao.findById(bookId).isEmpty()) {
			bookDao.deleteById(bookId);
			return ResponseEntity.ok(this.getBooks());
		}
		return ResponseEntity.badRequest().body("Failed to delete");
	}
	
	public ResponseEntity<Optional<Book>> getById(Long bookId){
		return ResponseEntity.ok(bookDao.findById(bookId));
	}

	public ResponseEntity<Optional<Book>> getByTitle(String title) {
		return ResponseEntity.ok(bookDao.findByTitleIgnoreCase(title));
	}
	
	
}
