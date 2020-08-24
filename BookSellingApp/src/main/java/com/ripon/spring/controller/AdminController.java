package com.ripon.spring.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	@RequestMapping("/admin")
	public String getAdminPage() {
		return "adminLogin";
	}
	
	@RequestMapping(value = "/editlibrary", method = RequestMethod.POST)
	public ModelAndView validateAdmin(@RequestParam Map<String, String> map) {
		String email = map.get("email");
		String password = map.get("password");
		
		if(email.equals("admin@gmail.com") && password.equals("root")) {
			ModelAndView mv = new ModelAndView("editLibrary");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("adminLogin");
			mv.addObject("status","Bad Admin. You are not a valid admin !");
			return mv;
		}
		
	}
}
