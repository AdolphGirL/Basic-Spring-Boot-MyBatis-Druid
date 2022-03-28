package com.example.starter.exception;

import lombok.Getter;

@Getter
public class JWTAuthException extends RuntimeException {
	
	private static final long serialVersionUID = 7918051102254855600L;
	
	private int code;
	private String msg;
	
	public JWTAuthException() {
		this(900, "JWT驗證失敗");
	}
	
	public JWTAuthException(String msg) {
		this(900, msg);
	}
	
	public JWTAuthException(int code, String msg) {
		super(msg);
		
		this.code = code;
		this.msg = msg;
	}
	
}
