package com.example.starter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.starter.domain.LoginUser;
import com.example.starter.utils.JwtUtil;

/**
 * 測試JWT
 */

@RestController
public class JwtController {
	
	/**
	 * 登入完成，回送JWT；下次發送請求後，該token會被放在Authorization header內。
	 * (一般為[類型 + tooken]，也可以自訂放置的格式、和自訂義的請求頭標籤
	 * @param user
	 * @return JWT
	 */
	@PostMapping("/jwt/login")
	public String sessionLogin(@RequestBody LoginUser user) {
		if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
			return JwtUtil.generateJWT(user.getUsername());
		}
		
		return "login falied";
	}
	
	@GetMapping("/jwt/api1")
	public String sessionApi1(HttpSession session) {
		return "access jwt api1 success";
	}
	
	@GetMapping("/jwt/api2")
	public String sessionApi2(HttpSession session) {
		return "access jwt api2 success";
	}
	
}
