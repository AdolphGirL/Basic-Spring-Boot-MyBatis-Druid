package com.example.starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.starter.bean.PropertiesBeanCar;
import com.example.starter.domain.Person;
import com.example.starter.domain.User;
import com.example.starter.service.PersonService;
import com.example.starter.service.UserService;

import lombok.extern.slf4j.Slf4j;

// lombok自帶處理log
@Slf4j
@RestController
public class HelloController {
	
	@Autowired
	private PropertiesBeanCar propertiesBeanCar;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PersonService personService;
	
	@GetMapping(value = "/hello", produces = "application/json;charset=UTF-8")
	public String hello(@RequestParam(value="name", defaultValue = "World")String name) {
		log.info("[+] [hello] get data: {} ", name);
		return String.format("Hello %s!", name);
	}
	
	@GetMapping("/pbc")
	public PropertiesBeanCar pbc() {
		return propertiesBeanCar;
	}
	
	@GetMapping("/user/{id}")
	public User queryUser(@PathVariable("id")int id) {
		return this.userService.queryUserById(id);
	}
	
	@GetMapping("/person/{id}")
	public Person queryPerson(@PathVariable("id")int id) {
		return this.personService.queryPersonById(id);
	}
	
	@GetMapping("/person/by/{name}")
	public Person queryPerson(@PathVariable("name")String name) {
		return this.personService.queryPersonByName(name);
	}
	
//	https://www.baeldung.com/spring-boot-json
	@PostMapping("/person")
	public Person createPerson(@RequestBody Person person) {
		return this.personService.savePerson(person);
	}
	
	@PutMapping("/person")
	public Person updatePerson(@RequestBody Person person) {
		return this.personService.updatePerson(person);
	}
}
