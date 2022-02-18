package com.example.starter.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有在容器中的組件，@ConfigurationProperties才會生效
 * 
 * 也可以在配置類別(SelfConfig.class)上使用@EnabledConfigurationProperties來改寫
 */
@ConfigurationProperties(prefix = "pbc")
@Component
public class PropertiesBeanCar {
	
	private String brand;
	private double price;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "PropertiesBeanCar [brand=" + brand + ", price=" + price + "]";
	}
	
}
