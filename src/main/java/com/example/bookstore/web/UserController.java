package com.example.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstore.domain.UserRepository;
import com.example.bookstore.model.SignUpForm;
import com.example.bookstore.model.User;

import javax.validation.Valid;

@Controller
public class UserController {
		@Autowired
	    private UserRepository urepository; 
		
	    @RequestMapping(value = "signup")
	    public String addUser(Model model){
	    	model.addAttribute("signupform", new SignUpForm());
	        return "signup";
	    }	
	    
	    /**
	     * Create new user
	     * Check if user already exists & form validation
	     * 
	     * @param signupForm
	     * @param bindingResult
	     * @return
	     */
	    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
	    public String save(@Valid @ModelAttribute("signupform") SignUpForm signupForm, BindingResult bindingResult) {
	    	if (!bindingResult.hasErrors()) { // validation errors
	    		if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) { // check password match		
		    		String pwd = signupForm.getPassword();
			    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
			    	String hashPwd = bc.encode(pwd);
		
			    	User newUser = new User();
			    	newUser.setPasswordHash(hashPwd);
			    	newUser.setUsername(signupForm.getUsername());
			    	newUser.setRole("USER");
			    	if (urepository.findByUsername(signupForm.getUsername()) == null) { // Check if user exists
			    		urepository.save(newUser);
			    	}
			    	else {
		    			bindingResult.rejectValue("username", "err.username", "Username already exists");    	
		    			return "signup";		    		
			    	}
	    		}
	    		else {
	    			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");    	
	    			return "signup";
	    		}
	    	}
	    	else {
	    		return "signup";
	    	}
	    	return "redirect:/login";    	
	    }    
	    
	}
