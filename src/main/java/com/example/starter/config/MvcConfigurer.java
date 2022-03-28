package com.example.starter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.starter.interceptor.LoginWithJWTInterceptor;
import com.example.starter.interceptor.LoginWithSessionInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebMvc
public class MvcConfigurer implements WebMvcConfigurer {
	
	/**
	 * @EnableWebMvc，啟用自訂義的mvc設定
	 * 但需要@Configuration，才能被初始化
	 * 
	 * 全域客製化springboot mvc設定
	 */
	
	public MvcConfigurer() {
		log.info("[+] [MvcConfigurer] start ... ");
	}
	
	/**
	 * 攔截器 interceptors
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry
			.addInterceptor(new LoginWithSessionInterceptor())
			.addPathPatterns("/session/**")
			.excludePathPatterns("/session/login", "/session/logout")
			.order(0);
		
		registry
//			添加攔截器
			.addInterceptor(new LoginWithJWTInterceptor())
//			檢查的路徑
			.addPathPatterns("/jwt/**")
//			排除的路徑
			.excludePathPatterns("/jwt/login")
//			執行順序
			.order(1);
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
	
}
