package com.example.starter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.starter.domain.LoginUser;
import com.example.starter.service.SessionService;

/**
 * 測試session登入
 */
@RestController
public class SessionController {
	
	@Autowired
	private SessionService sessionService;
	
	@PostMapping("/session/login")
	public String sessionLogin(@RequestBody LoginUser user, HttpSession session) {
		if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
			session.setAttribute("loginUser", user);
			return "login success";
		}
		
		return "login falied";
	}
	
	@GetMapping("/session/logout")
	public String sessionLogout(HttpSession session) {
		session.removeAttribute("loginUser");
		return "logout success";
	}
	
	@GetMapping("/session/api1")
	public String sessionApi1(HttpSession session) {
//		LoginFilter實現過濾
//		LoginUser user = (LoginUser) session.getAttribute("loginUser");
//		if (user == null) {
//			return "login first";
//		}
		
		this.sessionService.testGetSessionDataByRequestContext();
		
		return "access api success";
	}
	
	@GetMapping("/session/api2")
	public String sessionApi2(HttpSession session) {
//		LoginFilter實現過濾
//		LoginUser user = (LoginUser) session.getAttribute("loginUser");
//		if (user == null) {
//			return "login first";
//		}
		
		this.sessionService.testGetSessionDataByRequestContext();
		
		return "access api success";
	}
	
}
