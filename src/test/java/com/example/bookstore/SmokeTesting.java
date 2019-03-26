package com.example.bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.bookstore.web.BookController;
import com.example.bookstore.web.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTesting {
	@Autowired
	private BookController Bookcontroller;
	@Autowired
	private UserController Usercontroller;
	
	@Test
	public void contextLoads() throws Exception {
	assertThat(Bookcontroller).isNotNull();
	assertThat(Usercontroller).isNotNull();
	}
	}

