package com.example.starter.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.starter.domain.Member;
import com.example.starter.service.MyBatisService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BatisController {
	
	@Autowired
	private MyBatisService myBatisService;
	
	@GetMapping("/member/{id}")
	public Member queryPerson(@PathVariable("id")BigDecimal id) {
		return this.myBatisService.findMemberById(id);
	}
	
}
