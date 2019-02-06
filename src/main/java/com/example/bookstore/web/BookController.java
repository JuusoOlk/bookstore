package com.example.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstore.domain.Book;

@Controller
public class BookController {
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String friendList(Model model) {
		Book book = new Book();
		//book.setAuthor(author);
		//friends.add(friend);
		model.addAttribute("book", book);
		//model.addAttribute("friends", friends);
		//model.addAttribute("name", name);
		return "index";
}
}
