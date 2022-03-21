package com.example.starter.service.impl;

import org.springframework.stereotype.Service;

import com.example.starter.config.RequestContext;
import com.example.starter.service.SessionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SessionServiceImpl implements SessionService {
	
	/**
	 * 測試由服務層直接取得session資料(透過上下文的方式處理)
	 */
	@Override
	public void testGetSessionDataByRequestContext() {
		log.info("[+] [testGetSessionDataByRequestContext] get current login user: {} ", RequestContext.getCurrentUser());
	}
	
}
