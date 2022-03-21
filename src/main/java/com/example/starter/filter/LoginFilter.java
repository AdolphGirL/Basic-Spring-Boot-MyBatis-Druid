package com.example.starter.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.starter.domain.LoginUser;

@Component
public class LoginFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if ("/start/session/login".equals(request.getRequestURI())) {
			filterChain.doFilter(request, response);
			return;
		}

		LoginUser user = (LoginUser) request.getSession().getAttribute("loginUser");
		if (user != null) {
			filterChain.doFilter(request, response);
			return;
		}

//		設置回應為json
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("login first");
		out.flush();
		out.close();
	}

}
