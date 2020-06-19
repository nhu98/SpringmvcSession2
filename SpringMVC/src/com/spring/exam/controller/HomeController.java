package com.spring.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.exam.service.HomeService;

@Controller
public class HomeController {
	@Autowired
	private HomeService homeService;
	@GetMapping("/")
	public String index() {
		return ("index.html");
	}
	

}
