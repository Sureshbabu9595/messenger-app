package com.message.messenger.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessengerLoginController {
	
	@GetMapping("/login")
	public ModelAndView login(HttpServletRequest httpServletRequest) {
		return new ModelAndView("index");
	}

}
