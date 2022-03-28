package com.example.starter.exception;

import lombok.Getter;

@Getter
public class SessionAuthException extends RuntimeException {
	
	private static final long serialVersionUID = 6941756074980217567L;
	
	private int code;
	private String msg;
	
	public SessionAuthException() {
		this(901, "Session驗證失敗");
	}
	
	public SessionAuthException(String msg) {
		this(901, msg);
	}
	
	public SessionAuthException(int code, String msg) {
		super(msg);
		
		this.code = code;
		this.msg = msg;
	}
}
