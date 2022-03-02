package com.example.starter.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.starter.domain.Person;

/**
 *	DAO層不管是用xml annotation，都不會影響事務管理的方式
 */
@Mapper
public interface PersonMapper {
	
	public Person queryPersonById(int id);
	
//	annotation方式
	@Select(" select * from person where name = #{userName} ")
	public Person queryPersonByUserName(String userName);
	
	public int savePerson(Person person);
	
//	update @Param 指定方式
	@Update("update person set name=#{kperson.name}, email=#{kperson.email} where id=#{kid}")
	public int updatePerson(@Param("kid") int id, @Param("kperson") Person person);
	
}
