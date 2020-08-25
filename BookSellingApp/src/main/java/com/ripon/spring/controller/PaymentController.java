package com.ripon.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController {

	@GetMapping("/payment")
	public ModelAndView getPaymentPage(@RequestParam("book_name") String bname, @RequestParam("author") String author, @RequestParam("price") String price, @RequestParam("page") String page, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("paymentPage");
		session.setAttribute("book_name", bname);
		session.setAttribute("author", author);
		session.setAttribute("price", price);
		session.setAttribute("page", page);
		return mv;
	}
}
