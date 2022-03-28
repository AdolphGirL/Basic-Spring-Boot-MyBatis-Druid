package com.example.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.starter.bean.ImportUser;

import lombok.extern.slf4j.Slf4j;

// @SpringBootApplication @import 高級用法，

//	懶得每個Mapper都寫@Mapper，直接在此 or configuration 使用 mapperscan
//@MapperScan
@Slf4j
@SpringBootApplication
public class StarterBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(StarterBootApplication.class, args);
		
//		查看目前產生的所有bean
		String[] arr = run.getBeanDefinitionNames();
		for(String name : arr) {
			log.info("[+] [main] bean name: {} ", name);
		}
		
//		測試code
//		BeanPet pet1 = run.getBean("pet", BeanPet.class);
//		BeanPet pet2 = run.getBean("pet", BeanPet.class);
//		
//		System.out.println("[+] pet1 == pet2: " + (pet1 == pet2));
		
//		TODO 測試，@Import；在SelfConfig，使用了import
//		ImportUser importUser = run.getBean("com.example.starter.bean.ImportUser", ImportUser.class);
//		log.info("[+] [main] importUser: {} ", importUser);
		
//		測試ConditionalOnBean
//		boolean isHasBeanPet = run.containsBean("beanPet");
//		log.info("[+] [main] isHasBeanPet: {} ", isHasBeanPet);
//		
	}

}

/**
 * static content
 * https://docs.spring.io/spring-boot/docs/2.5.8/reference/html/features.html#features.developing-web-applications
 * 
 * 請求處理時，會先確認有沒有對應的controller處理。
 * 沒有的話，會交由static mapping /**，攔截所有請求，因此會換靜態資源處理，根據請求名稱去靜態資源內部尋找
 * 
 * spring.mvc.static-path-pattern=/resources/**
 * 替靜態資源加上前墜。默認是 /**
 */
