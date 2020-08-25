package com.ripon.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.ripon.spring.entity.User;


@Repository
public class UserDao {
	
	private HibernateTemplate hibernateTemplate;
	
	//setter
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	/** It returns the details of a user **/
	public User getUser(String id) {
		return hibernateTemplate.get(User.class, id);
	}
	
	
	
	
	/**
	 * It inserts User values into database. Returs true if success and returns
	 * false if exception occurs.
	 **/
	@Transactional
	public boolean insertUserRecord(User user) {
		try {
			hibernateTemplate.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	//It returns all the user info as a List object
	public List<User> getAllUserRecord() {
		Session s = hibernateTemplate.getSessionFactory().openSession();
		Query query = s.createQuery("FROM User");
		List list = query.list();
		return list;
	}
}
