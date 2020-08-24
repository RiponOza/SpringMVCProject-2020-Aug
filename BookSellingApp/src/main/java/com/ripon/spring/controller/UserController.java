package com.ripon.spring.controller;

import java.util.Map;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ripon.spring.entity.User;
import com.ripon.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST )
	public ModelAndView saveUser(@RequestParam  Map<String, String> map) {
		ModelAndView mv = new ModelAndView("register");
		User user = new User();
		user.setEmail(map.get("email"));
		user.setFname(map.get("fname"));
		user.setLname(map.get("lname"));
		user.setMobile(map.get("mobile"));
		user.setPassword(map.get("password"));
		user.setGender(map.get("gender"));
		
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
	
	@RequestMapping("/test")
	public String getAllUsers() {
		System.out.println("inside controller");
		userService.getAllUsers();
		return "index";
	}
}
