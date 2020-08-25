package com.ripon.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.ripon.spring.entity.Book;

@Repository
@EnableTransactionManagement
public class BookDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	
	//checks for availability of entry of book in database
	public boolean isRecordAvailable(Book book) {  
		if(hibernateTemplate.get(Book.class, book.getId())==null) {
			return false;
		}
		return true;
	}
	
	
	
	// insert value in db
	@Transactional
	public boolean insertBookRecord(Book book) {
		try {
			hibernateTemplate.save(book);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	// delete value from database
	@Transactional
	public boolean deleteBookRecord(Book book) {
		try {
			hibernateTemplate.delete(book);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	// updates existing record from database
	@Transactional
	public boolean updateBookRecord(Book book) {
		try {
			hibernateTemplate.update(book);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	// get book record using Book Id, returns null if not available
	public Book getBookRecord(long id ) {
		try {
			Book book = hibernateTemplate.get(Book.class, id);
			if(book != null) {
				return book;
			} else {
				return null;
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	// returns all book records present in database as List object
	public List<Book> getAllBookRecord() {
		try {
			Session session =  hibernateTemplate.getSessionFactory().openSession();
			Query query = session.createQuery("FROM Book");
			List<Book> bookList = query.list();
			return bookList;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
