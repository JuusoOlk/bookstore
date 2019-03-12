package com.example.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Category;


@SpringBootApplication
public class BookstoreApplication {
	@Autowired
	private BookRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		
	}
	
	@Bean
	public CommandLineRunner Book(BookRepository brepository, CategoryRepository crepository) {
	return (args) -> {
		
		crepository.save(new Category("Fiction"));
		crepository.save(new Category("Horror"));
		crepository.save(new Category("History"));
		
		brepository.save(new Book("Erkki Testaaja", "KH25123", "Jaakon Seikkailut", 2020, 13.45, crepository.findByName("Fiction").get(0)));
	
	};
	}
}
