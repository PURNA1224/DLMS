package com.example.DigitalLibrary.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DigitalLibrary.model.Book;
import com.example.DigitalLibrary.service.BookServices;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = {"https://cool-kataifi-1ff576.netlify.app", "http://localhost:5173"})
@RequestMapping("/books")
public class BooksController {
	
	@Autowired
	private BookServices bookServices;
	
	@PostMapping("/addBook")
	public ResponseEntity<String> addBook(@Valid @RequestBody Book book) {
		return bookServices.addBookService(book);
	}
	
	@GetMapping("/getBooks")
	public ResponseEntity<List<Book>> getBooks(){
		return bookServices.getBooks();
	}
	
	@GetMapping("/searchByIdOrTitle")
	public ResponseEntity<?> getBookBYIdOrTitle(@RequestParam(required = false) Long bookId, @RequestParam(required = false) String title) {
		System.out.println("Updated");
		return bookServices.getBookByIdOrTitle(bookId, title);
	}
	
	@PostMapping("/updateBook")
	public ResponseEntity<String> updateBook(@RequestBody Book book){
		return bookServices.updateBook(book);
	}
	
	@DeleteMapping("/deleteBook")
	public ResponseEntity<?> deleteBook(@RequestParam Long bookId){
		return bookServices.deleteBook(bookId);
	}
	
	@PostMapping("/searchById")
	public ResponseEntity<Optional<Book>> getById(@RequestParam Long bookId){
		return bookServices.getById(bookId);
	}
	
	@PostMapping("/searchByTitle")
	public ResponseEntity<Optional<Book>> getByName(@RequestParam String title){
		return bookServices.getByTitle(title);
	}
	
}
