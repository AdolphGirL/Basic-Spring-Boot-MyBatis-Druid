package com.example.starter.response;

import lombok.Getter;

/**
 * 處理統一回應的數據(當需要json 回應的時候，使用)
 */
@Getter
public class ResultVO<T> {
	
//	http status code
	private int code;
	
//	回應訊息
	private String msg;
	
//	payload
	private T data;
	
//	改造
//	public ResultVO(T data) {
//		this(1000, "success", data);
//	}
	
	public ResultVO(T data) {
		this(ResultCode.SUCCESS, data);
	}
	
	public ResultVO(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	/**
	 * 列舉使用
	 * @param resultCode
	 * @param data
	 */
	public ResultVO(ResultCode resultCode, T data) {
		this.code = resultCode.getCode();
		this.msg = resultCode.getMsg();
		this.data = data;
	}
	
}
