package com.ripon.spring.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ripon.spring.entity.Book;
import com.ripon.spring.entity.User;
import com.ripon.spring.service.BookService;
import com.ripon.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@Autowired
	BookService bookService;
	
	
	
	
	@PostMapping(value = "saveuser")
	public ModelAndView saveUser(@RequestParam  Map<String, String> map) {
		ModelAndView mv = new ModelAndView("register");
		
		User user = userService.getUserObject(map);
		
		int status = userService.addUser(user);
		if(status==1) {
			mv.addObject("status","successfully saved !");
			mv.addObject("user",user);
		}else if(status==2) {
			mv.addObject("status","Email id is already registered. Try another email id.");
		} else {
			mv.addObject("status","Error occured. Try again later !");
		}
		
		return mv;
	}
	
	
	
	
	
	
	/**
	 * it validates the user and redirects him to the Library page if validation is
	 * correct. Else it shows error message in index.jsp page
	 **/
	@PostMapping("userlogin")
	public ModelAndView loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		if (userService.validateLoginData(email, password)) {
			List<Book> bookList = bookService.getAllBook();
			mv.addObject("bookList", bookList);
			mv.setViewName("Library");
			
		} else {
			mv.setViewName("index");
			mv.addObject("status", "Username or Password is wrong !!");
		}

		return mv;
	}
	
	
	
	
	
	@RequestMapping("/test")
	public String getAllUsers() {
		System.out.println("inside controller");
		userService.getAllUsers();
		return "index";
	}
}
