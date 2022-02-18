package com.example.starter.service;

import com.example.starter.domain.Person;

public interface PersonService {
	
	public Person queryPersonById(int id);
	
	public Person queryPersonByName(String name);
	
	public Person savePerson(Person person);
	
	public Person updatePerson(Person person);
	
}
