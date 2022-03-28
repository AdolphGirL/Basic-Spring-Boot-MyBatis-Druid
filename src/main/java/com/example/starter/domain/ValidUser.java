package com.example.starter.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ValidUser {
	
	@NotNull(message = "用戶ID不得為空")
	private Long id;
	
	@NotNull(message = "用戶帳號不得為空")
	@Size(min = 6, max = 11, message = "帳號長度須為6-11個字")
	private String name;
	
	@NotNull(message = "用戶EMAIL不得為空")
	@Email(message = "用戶EMAIL格式不正確")
	private String email;
	
}
