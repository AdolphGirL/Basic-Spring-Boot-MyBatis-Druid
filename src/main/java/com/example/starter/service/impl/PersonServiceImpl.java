package com.example.starter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.starter.domain.Person;
import com.example.starter.mapper.PersonMapper;
import com.example.starter.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonMapper personMapper;
	
	@Override
	public Person queryPersonById(int id) {
		return this.personMapper.queryPersonById(id);
	}
	
	@Override
	public Person queryPersonByName(String name) {
		return this.personMapper.queryPersonByUserName(name);
	}

	@Override
	public Person savePerson(Person person) {
		int num = this.personMapper.savePerson(person);
		log.info("[+] [savePerson] save person done: {} ", num);
		return person;
	}

	@Override
	public Person updatePerson(Person person) {
		int num = this.personMapper.updatePerson(person.getId(), person);
		log.info("[+] [savePerson] update person done: {} ", num);
		return person;
	}
	
}
