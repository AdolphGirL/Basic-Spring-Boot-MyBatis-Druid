package com.example.starter.exception;

import lombok.Getter;

/**
 * 自訂義處理的異常
 * (setter不需要)
 */
@Getter
public class APIException extends RuntimeException {
	
	private static final long serialVersionUID = 8271147022416440392L;
	
	private int code;
	private String msg;
	
	public APIException() {
		this(101, "API操作失敗");
	}
	
	public APIException(String msg) {
		this(101, msg);
	}
	
	public APIException(int code, String msg) {
		super(msg);
		
		this.code = code;
		this.msg = msg;
	}
	
}
