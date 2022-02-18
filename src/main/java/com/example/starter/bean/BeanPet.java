package com.example.starter.bean;

import lombok.Data;

@Data
public class BeanPet {
	
	private String name;

	public BeanPet() {
	}
	
	public BeanPet(String name) {
		this.name = name;
	}
	
}
