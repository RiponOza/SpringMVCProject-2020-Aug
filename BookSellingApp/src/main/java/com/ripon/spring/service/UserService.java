package com.ripon.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ripon.spring.dao.UserDao;
import com.ripon.spring.entity.Book;
import com.ripon.spring.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	//setter method
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	
	/** converts Map object taken from request scope to a User object. **/
	public User getUserObject(Map<String, String> map) {
		User user = new User();
		user.setEmail(map.get("email"));
		user.setFname(map.get("fname"));
		user.setLname(map.get("lname"));
		user.setMobile(map.get("phone"));
		user.setPassword(map.get("password"));
		user.setGender(map.get("gender"));
		System.out.println(user.getMobile());
		System.out.println(user.getEmail());
		return user;
	}
	
	
	
	
	/** It inserts user data into User table **/
	public int addUser(User user) {

		if (userDao.insertUserRecord(user)) {
			return 1;
		} else {
			return 0;
		}

	}
	
	
	
	
	//business method
	public void getAllUsers() {
		System.out.println("inside service");
		List<User> users = userDao.getAllUserRecord();
		for(User user : users) {
			System.out.println(user.getFname());
			System.out.println(user.getLname());
			System.out.println(user.getEmail());
			System.out.println(user.getMobile());
			System.out.println("\n");
		}
	}

	
	
	/**
	 * It validates the email and password entered by user Returns true if email and
	 * password both are valid, Returns false if email or password is invalid
	 **/
	public boolean validateLoginData(String email, String password) {
		try {
			User user = userDao.getUser(email);
			if ((email.equals(user.getEmail())) && (password.equals(user.getPassword()))) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
}
