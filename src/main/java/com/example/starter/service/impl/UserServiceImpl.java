package com.example.starter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.starter.domain.User;
import com.example.starter.mapper.UserMapper;
import com.example.starter.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User queryUserById(int id) {
		return this.userMapper.queryUserById(id);
	}

}
