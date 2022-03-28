package com.example.starter.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.example.starter.domain.LoginUser;
import com.example.starter.exception.SessionAuthException;

public class LoginWithSessionInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		LoginUser user = (LoginUser) request.getSession().getAttribute("loginUser");
		if (user != null) {
			return true;
		}
		
		throw new SessionAuthException("請先登入系統");
	}
	
}
