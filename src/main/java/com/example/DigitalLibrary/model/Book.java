package com.example.DigitalLibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	
//	@NotEmpty(message = "Title cannot be empty")
	private String title;
	
//	@NotEmpty(message = "Author cannot be empty")
	private String author;
	
	private String genre;
	
//	@NotBlank(message = "Availability status cannot be empty")
	private String availability_status;
	
	public Book() {
		super();
	}

	public Book(Long bookId, @NotEmpty(message = "Title cannot be empty") String title,
			@NotEmpty(message = "Author cannot be empty") String author, String genre,
			@NotEmpty(message = "Availability status cannot be empty") String availability_status) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.availability_status = availability_status;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAvailability_status() {
		return availability_status;
	}

	public void setAvailability_status(String availability_status) {
		this.availability_status = availability_status;
	}
	
}
