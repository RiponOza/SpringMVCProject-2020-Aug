package com.ripon.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ripon.spring.service.UserService;


@Controller
public class FirstController {
	
	@RequestMapping(value = {"/","/indexpage"})
	public String getIndexPage() {
		return "index";
	}
	
	@RequestMapping("/register")
	public String getRegisterPage() {
		return "register";
	}
	
	
	

}
