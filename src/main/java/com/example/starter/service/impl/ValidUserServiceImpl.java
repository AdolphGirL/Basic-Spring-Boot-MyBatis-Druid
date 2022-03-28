package com.example.starter.service.impl;

import org.springframework.stereotype.Service;

import com.example.starter.domain.ValidUser;
import com.example.starter.service.ValidUserService;


/**
 * 測試valid驗證
 */

@Service
public class ValidUserServiceImpl implements ValidUserService {

	/**
	 * 原先要驗證的部分，交由javax.validation驗證
	 */
	@Override
	public String addValidUser(ValidUser user) {
//		不需要了
//		if (user.getId() <= 0) {
//			return "xxxx";
//		}
		
		return "success";
	}
	
	
	
}
