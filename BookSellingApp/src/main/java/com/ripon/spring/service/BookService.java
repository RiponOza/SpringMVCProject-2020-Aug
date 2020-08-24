package com.ripon.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ripon.spring.dao.BookDao;
import com.ripon.spring.entity.Book;

@Service
public class BookService {

	@Autowired
	private BookDao dao;
	private String image = "Not Available";
	private boolean status;

	// converts Map object taken from request scope to a Book object.
	public Book getBookObject(Map<String, String> map) {
		Book book = new Book();
		book.setId(Long.parseLong(map.get("Id")));
		book.setBname(map.get("bname"));
		book.setAuthor(map.get("author"));
		book.setPrice(Double.parseDouble(map.get("price")));
		book.setTotalpage(Long.parseLong(map.get("totalpage")));
		book.setImage(image);
		return book;
	}

	// it does server side validation of the data present in Book object.
	public boolean validateBook(Book book) {
		return true; // Not complete
	}

	// insert method
	// returns 1 if successful, returns 2 if record already available, returns 0 for
	// failure.
	public int insertBook(Book book) {
		if (dao.isRecordAvailable(book) == false) {
			status = dao.insertBookRecord(book);
			if (status) {
				return 1;
			}
		} else if (dao.isRecordAvailable(book) == true) {
			return 2;
		}

		return 0;
	}

	// returns 1 if successful, returns 2 if record not available, returns 0 for
	// failure.
	public int deleteBook(Book book) {
		if (dao.isRecordAvailable(book)) {
			status = dao.deleteBookRecord(book);
			if(status) {
				return 1;
			}
		} else if (!(dao.isRecordAvailable(book))) {
			return 2;
		} 
		return 0;
	}

	// get book record using Book Id, returns null if record not available
	public Book getBook(long id) {
		Book book = dao.getBookRecord(id);
		return book;
	}

	public int updateBook(Book book) {
		return 0;
	}

	public List<Book> getAllBook() {
		return null;
	}

}
