package com.example.starter.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.starter.domain.Member;

@Mapper
public interface MemberMapper {
	
	@Select("select * from Member where id = #{id}")
	public Member findMemberById(BigDecimal id);
	
}
