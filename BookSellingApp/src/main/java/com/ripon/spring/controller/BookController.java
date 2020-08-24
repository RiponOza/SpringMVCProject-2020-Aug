package com.ripon.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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

	/** this adds book value to the database **/
	@RequestMapping(value = "addbook", method = RequestMethod.POST)
	public ModelAndView addBook(@RequestParam("BookImage") MultipartFile imageFile,
			@RequestParam Map<String, String> map) {
		ModelAndView mv = new ModelAndView("addBook");

		// it converts Map object to Book object
		Book book = bservice.getBookObject(map);
		// it sets the image name as the original image name
		book.setImage(imageFile.getOriginalFilename());
		
		// it inserts book data only when data is valid.
		if (bservice.validateBook(book)) {
			status = bservice.insertBook(book);

			if (status == 1) {
				// upload book image when book data is valid and also inserted
				int bookUploadStatus = bservice.saveImage(imageFile);
				if (bookUploadStatus == 1) {
					mv.addObject("status", "Your book is successfully added.");
				} else if (bookUploadStatus == 404) {
					mv.addObject("imageStatus", "Please select a book image.");
				} else if (bookUploadStatus == 0) {
					mv.addObject("imageStatus", "Opps, Error occured. Please try again !");
				} else if (bookUploadStatus == 101) {
					mv.addObject("imageStatus", "Image size can't be more than 1 MB.");
				}
			} else if (status == 2) {
				mv.addObject("status", "Duplicate entry of this book is availabe.Try different one.");
			} else if (status == 0) {
				mv.addObject("status", "Opps, something went wrong.Try again.");
			}
		}

		if (status == 1) {

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
		} catch (Exception e) {
			mv.addObject("status", "Id should be number only.");
			return mv;
		}

		Book book = bservice.getBook(Id);

		if (book != null) {
			status = bservice.deleteBook(book);
			if (status == 1) {
				mv.addObject("status", "Your book is successfully removed.");
			} else if (status == 2) {
				mv.addObject("status", "This book is not availabe in our database.");
			} else if (status == 0) {
				mv.addObject("status", "Opps, something went wrong.Try again.");
			} else {
				mv.addObject("status", "Opps, something went wrong.Try again.");
			}
		} else {
			mv.addObject("status", "This book is not availabe in our database.");
		}

		return mv;
	}

}
