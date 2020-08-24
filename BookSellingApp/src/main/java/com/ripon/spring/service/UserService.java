package com.ripon.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ripon.spring.dao.UserDao;
import com.ripon.spring.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	//setter method
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//It inserts user data into User table
	public int addUser(User user) {
		return userDao.insertUserRecord(user);
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
	
}
