package com.example.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.BookRepository;

import ch.qos.logback.classic.Logger;

import com.example.bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {
	@Autowired
	private BookRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		
	}
	
	@Bean
	public CommandLineRunner Book(BookRepository repository) {
	return (args) -> {
		repository.save(new Book (1, "Erkki Testaaja", "KH25123", "Jaakon Seikkailut", 2020, 13.45));
		
	
	};
	}
}

