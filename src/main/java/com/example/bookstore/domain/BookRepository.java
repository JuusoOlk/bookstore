package com.example.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.bookstore.model.Book;
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByid(Long id);
}
