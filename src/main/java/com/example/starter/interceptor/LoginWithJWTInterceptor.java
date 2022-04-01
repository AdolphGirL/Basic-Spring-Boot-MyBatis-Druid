package com.example.starter.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.starter.config.JWTUserContext;
import com.example.starter.exception.JWTAuthException;
import com.example.starter.utils.JwtUtil;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;

//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 特意不加在filter，目前的filter有session的測試
 * 
 * implements WebMvcConfigurer
 *	
 *	SpringBoot2.0，Spring5.0 棄用 HandlerInterceptorAdapter
 *	
 *	https://openhome.cc/Gossip/Spring/Interceptor.html
 */
//public class LoginInterceptor extends HandlerInterceptorAdapter {
//	
//}

@Slf4j
public class LoginWithJWTInterceptor implements HandlerInterceptor {
	
	/**
	 * Interceptor，可以取得http請求，對應的處理方法(Object handler)(filter取不到)，與請求(HttpServletRequest request)
	 * spring控管Interceptor
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String auth = request.getHeader("Authorization");
		log.info("[+] [preHandle] request Authorization: {} ", auth);
		
		if (StringUtils.hasText(auth)) {
			Claims claims = JwtUtil.parseJWT(auth);
			if (claims != null) {
				JWTUserContext.add(claims.getSubject());
				return true;
			}
		}
		
////		TODO 需要修改為全局配置
//		response.setContentType("application/json;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.write("login first");
//		out.flush();
//		out.close();
		
		throw new JWTAuthException("請先登入系統");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//		請求完成，需要刪除
		JWTUserContext.remove();
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	
	
}
