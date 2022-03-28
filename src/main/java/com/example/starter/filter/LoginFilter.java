package com.example.starter.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import lombok.extern.slf4j.Slf4j;

/**
 * 先取消，改寫在interceptor
 *
 */
//@Slf4j
//@Component
public class LoginFilter extends OncePerRequestFilter {
	
	@Value("${server.servlet.context-path}")
	private String rootPath;
	
//	@Qualifier 收尋 by name，@Autowired預設是by type
	@Autowired
	@Qualifier("handlerExceptionResolver")
	private HandlerExceptionResolver resolver;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
//		log.info("[+] [doFilterInternal] rootPath uri: {} ", this.rootPath);
//		log.info("[+] [doFilterInternal] filter uri: {} ", request.getRequestURI());
//		log.info("[+] [doFilterInternal] filter uri: {} ", request.getRequestURL().toString());
		
		filterChain.doFilter(request, response);
		
//		首頁放行
//		if ((this.rootPath + "/").equals(request.getRequestURI())) {
//			filterChain.doFilter(request, response);
//			return;
//		}
//		
//		if ((this.rootPath + "/session/login").equals(request.getRequestURI())) {
//			filterChain.doFilter(request, response);
//			return;
//		}
//		
////		測試jwt使用，直接放行
//		if (request.getRequestURI().startsWith(this.rootPath + "/jwt")) {
//			filterChain.doFilter(request, response);
//			return;
//		}
//		
////		測試validation
//		if (request.getRequestURI().startsWith(this.rootPath + "/valid")) {
//			filterChain.doFilter(request, response);
//			return;
//		}
//		
//		LoginUser user = (LoginUser) request.getSession().getAttribute("loginUser");
//		if (user != null) {
//			filterChain.doFilter(request, response);
//			return;
//		}
		
//		TODO 需改由全局異常處理，加入HandlerExceptionResolver，但要注意resolveException回傳是ModelAndView
//		設置回應為json
//		response.setContentType("application/json;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.write("login first");
//		out.flush();
//		out.close();
		
//		改後的程式，先交由@RestControllerAdvice處理
//		resolver.resolveException(request, response, null, new FilterException("不可以登入"));
	}

}
