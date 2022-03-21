package com.example.starter.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.starter.domain.LoginUser;

/**
 * 透過spring mvc 提供的RequestContextHolder，從上下文取得session資料
 *
 */
public class RequestContext {
	
	public static HttpServletRequest getCurrentRequest() {
		return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
	}
	
	public static LoginUser getCurrentUser() {
		return (LoginUser)getCurrentRequest().getSession().getAttribute("loginUser");
	}
}
