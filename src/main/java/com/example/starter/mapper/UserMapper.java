package com.example.starter.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.starter.domain.User;

/**
 * MybatisAutoConfiguration 會自動掃描，Searching for mappers annotated with @Mapper
 * Exploring Mapped SQL Statements
 */
@Mapper
public interface UserMapper {

	public User queryUserById(int id);

}
