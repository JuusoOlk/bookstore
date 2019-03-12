package com.example.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.bookstore.model.Category;


public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findByName(String name);
	
}
