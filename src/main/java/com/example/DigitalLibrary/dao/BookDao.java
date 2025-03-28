package com.example.DigitalLibrary.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.DigitalLibrary.model.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Long>{
	public Optional<Book> findByTitleIgnoreCase(String title);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "update Book set title=:title, author=:author, genre=:genre, availability_status=:availability_status where bookId=:bookId")
	public void updateById(Long bookId, String title, String author, String genre, String availability_status);
}
