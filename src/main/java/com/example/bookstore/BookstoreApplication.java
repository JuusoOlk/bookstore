package com.example.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;
import com.example.bookstore.domain.UserRepository;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.User;

@SpringBootApplication
public class BookstoreApplication {
	@Autowired
	private UserRepository urepository;
	
	@Autowired
	private BookRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		
	}
	@Bean
	public CommandLineRunner Book(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
	return (args) -> {
		
		crepository.save(new Category("Fiction"));
		crepository.save(new Category("Horror"));
		crepository.save(new Category("History"));
		
		brepository.save(new Book("Erkki Testaaja", "KH25123", "Jaakon Seikkailut", 2020, 13.45, crepository.findByName("Fiction").get(0)));
		
		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		urepository.save(user1);
		urepository.save(user2);
		
	};
	}
}
