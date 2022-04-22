package com.example.starter.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.starter.domain.Member;
import com.example.starter.mapper.MemberMapper;
import com.example.starter.service.MyBatisService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MyBatisServiceImpl implements MyBatisService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public Member findMemberById(BigDecimal id) {
		return this.memberMapper.findMemberById(id);
	}
	
	
	
	
}
