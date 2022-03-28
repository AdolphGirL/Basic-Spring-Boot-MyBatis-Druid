package com.example.starter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("hello", "歡迎光臨");
		return "index";
	}
	
	@GetMapping("/index")
	public ModelAndView index(ModelAndView m) {
		m.setViewName("index");
		return m;
	}
	
	@GetMapping("/testRes")
	public ModelAndView testRes(ModelAndView m) {
		m.setViewName("testRes");
		return m;
	}
}
