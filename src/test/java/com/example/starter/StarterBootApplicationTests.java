package com.example.starter;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class StarterBootApplicationTests {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	void contextLoads() {
		List<Map<String, Object>> d = jdbcTemplate.queryForList(" select * from user ");
		d.forEach(x -> {
			x.forEach((k, y) -> {
				log.info("[+] key: {}、value: {} ", k, y);
			});
		});
	}

}
