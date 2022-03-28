package com.example.starter.advice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.starter.exception.APIException;
import com.example.starter.exception.JWTAuthException;
import com.example.starter.exception.SessionAuthException;
import com.example.starter.response.ResultCode;
import com.example.starter.response.ResultVO;

/**
 * @ControllerAdvice or @RestControllerAdvice，來縫合controller異常的處理
 * 兩者的差異在於，ControllerAdvice需要返回json數據時，需要在每個方法前加上@ResponseBody
 * RestControllerAdvice則不用(如public ResultVO<String> ExceptionHandler(Exception e)這個例子)
 * 
 * 由此控制所有異常統一回覆訊息。
 * 配合單體系統的可能，
 * 一次控制，controller restcontroller(需要回應，自行加上@ResponseBody)
 */

@ControllerAdvice
public class GlobalExceptionControllerAdvice {
	
	public static final String DEFAULT_ERROR_VIEW = "error/SessionError";
	
	@ExceptionHandler(JWTAuthException.class)
	@ResponseBody
	public ResultVO<String> JWTAuthExceptionHandler(JWTAuthException e) {
		return new ResultVO<>(ResultCode.JWT_FAILED, e.getMsg());
	}
	
	@ExceptionHandler(SessionAuthException.class)
	public ModelAndView SessionAuthExceptionHandler(HttpServletRequest req, SessionAuthException e) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}
	
	
	/**
	 * 處理Exception
	 */
//	未統一回應的方式
//	@ExceptionHandler(Exception.class)
//	public String ExceptionHandler(Exception e) {
//		return e.getMessage();
//	}
	@ExceptionHandler(Exception.class)
	public ResultVO<String> ExceptionHandler(Exception e) {
		return new ResultVO<>(ResultCode.ERROR, e.getMessage());
	}
	
	
	/**
	 * 指定處理valid驗證的錯誤訊息
	 */
//	未統一回應的方式
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public String MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
//		ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
//		return objectError.getDefaultMessage();
//	}
	
	/**
	 * 指定處理valid驗證的錯誤訊息
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResultVO<List<String>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		if (e.getBindingResult().getAllErrors() != null) {
			return new ResultVO<>(ResultCode.VALIDATE_FAILED, 
						e.getBindingResult().getAllErrors()
							.stream().map(x -> {
								return x.getDefaultMessage();
							}).collect(Collectors.toCollection(ArrayList::new)));
		}
		
		return new ResultVO<>(ResultCode.ERROR, Arrays.asList("驗證錯誤"));
	}
	
	/**
	 * 處理自己定義錯誤
	 */
//	未統一回應的方式
//	@ExceptionHandler(APIException.class)
//	public String APIExceptionHandler(APIException e) {
//		return e.getMsg();
//	}
	
	@ExceptionHandler(APIException.class)
	@ResponseBody
	public ResultVO<String> APIExceptionHandler(APIException e) {
		return new ResultVO<>(ResultCode.API_FAILED, e.getMsg());
	}
	
}
