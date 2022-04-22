package com.example.starter.service;

import java.math.BigDecimal;

import com.example.starter.domain.Member;

public interface MyBatisService {
	
	public Member findMemberById(BigDecimal id);
	
}
