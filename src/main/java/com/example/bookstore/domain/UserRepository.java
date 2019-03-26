package com.example.bookstore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.bookstore.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
