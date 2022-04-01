package com.example.starter.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.example.starter.exception.APIException;
import com.example.starter.response.ResultVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 建構統一處理restcontroller回應的統一格式(尚未理解，如何捕捉到)
 * 
 * 	在controller將數據進行返回操作前進行增強操作
 * 	supports，true，才會執行beforeBodyWrite，在該方法內包裝數據，這樣就不需要每個接口都進行統一數據的封裝
 *	
 *	basePackages，指定處理的package；
 *
 *	會根據Content-Type來選擇一個HttpMessageConverter來處理，因此該controller如果沒有指定可以接受回應的格式，則繁體會出問題
 *	produces，指定回應的格式
 */
@RestControllerAdvice(basePackages = {"com.example.starter.controller"})
public class RestResponseControllerAdvice implements ResponseBodyAdvice<Object> {

	/**
	 * 判斷是否需要進行封裝
	 */
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return !returnType.getParameterType().equals(ResultVO.class);
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		
//		string直接封給ResultVO<>(body)，會發生com.example.starter.response.ResultVO cannot be cast to java.lang.String
//		原因尚未處理
//		將String資料，封裝到ResultVO再轉為JSON字串，到這邊繁體都正常
		if (returnType.getGenericParameterType().equals(String.class)) {
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				return objectMapper.writeValueAsString(new ResultVO<>(body));
			} catch (JsonProcessingException e) {
				throw new APIException("返回字串類型有誤");
			}
		}
		
		return new ResultVO<>(body);
	}

}
