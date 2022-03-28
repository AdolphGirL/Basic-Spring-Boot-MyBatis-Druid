package com.example.starter.response;

import lombok.Getter;

/**
 * 自訂義處理錯誤的列舉
 * 
 * 驗證，由9開頭
 * 操作，由1開頭
 * 
 * 為預期錯誤 500
 *
 */
@Getter
public enum ResultCode {
	
	JWT_FAILED(900, "JWT驗證失敗"),
	
	SESSION_FAILED(901, "JWT驗證失敗"),
	
	SUCCESS(100, "操作成功"),
	
	API_FAILED(101, "API操作失敗"),
	
	VALIDATE_FAILED(102, "參數驗證失敗"),
	
	ERROR(500, "未預期錯誤");

	private int code;
	private String msg;

	ResultCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
