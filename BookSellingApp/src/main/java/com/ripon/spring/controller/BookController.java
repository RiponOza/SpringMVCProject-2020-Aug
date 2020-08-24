package com.ripon.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ripon.spring.entity.Book;
import com.ripon.spring.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bservice;
	
	private int status;

	// gives the addBook.jsp page
	@RequestMapping(value = "addbookview", method = RequestMethod.POST)
	public String getAddBookView() {
		return "addBook";
	}
	

	// gives the deleteBook.jsp page
	@RequestMapping(value = "deletebookview", method = RequestMethod.POST)
	public String getDeleteBookView() {
		return "deleteBook";
	}

	// this adds book value to the database
	@RequestMapping(value = "addbook", method = RequestMethod.POST)
	public ModelAndView addBook(@RequestParam Map<String, String> map) {
		ModelAndView mv = new ModelAndView("addBook");
		Book book = bservice.getBookObject(map);

		if (bservice.validateBook(book)) {
			status = bservice.insertBook(book);

			if (status == 1) {
				mv.addObject("status", "Your book is successfully added.");
			} else if (status == 2) {
				mv.addObject("status", "Duplicate entry of this book is availabe.Try different one.");
			} else if (status == 0) {
				mv.addObject("status", "Opps, something went wrong.Try again.");
			} 
		}

		return mv;
	}
	
	// Deletes book record from database
	@RequestMapping(value = "deletebook", method = RequestMethod.POST)
	public ModelAndView deleteBook(@RequestParam(name = "Id") String bookId) {
		ModelAndView mv = new ModelAndView("deleteBook");
		long Id;
		
		// validating Id type, it must be a number type
		try {
			Id = Long.parseLong(bookId);
		} catch(Exception e) {
			mv.addObject("status", "Id should be number only.");
			return mv;
		}
		
		Book book = bservice.getBook(Id);
		
		if(book != null) {
			status = bservice.deleteBook(book);
			if(status == 1) {
				mv.addObject("status", "Your book is successfully removed.");
			} else if (status == 2) {
				mv.addObject("status", "This book is not availabe in our database.");
			} else if (status == 0) {
				mv.addObject("status", "Opps, something went wrong.Try again.");
			}  else {
				mv.addObject("status", "Opps, something went wrong.Try again.");
			}
		} else {
			mv.addObject("status", "This book is not availabe in our database.");
		}
		
		return mv;	
	}

}
