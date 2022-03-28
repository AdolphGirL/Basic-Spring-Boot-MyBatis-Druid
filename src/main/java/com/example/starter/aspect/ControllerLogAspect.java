package com.example.starter.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class ControllerLogAspect {
	
	public ControllerLogAspect() {
		log.info("[+] [ControllerLogAspect] init ... ");
	}
	
	/**
	 * 切入點
	 */
	@Pointcut("execution(* com.example.starter.controller..*.*(..))")
	public void pointcut() {
	}
	
	@Before("pointcut()")
	public void before(JoinPoint joinPoint) {
		String methodName = getMethodName(joinPoint);
		if (joinPoint.getArgs() != null) {
			Arrays.stream(joinPoint.getArgs()).forEach(x -> {
				log.info("[+] [before] excute method name: {}，args: {} ", methodName, x);
			});
		} else {
			log.info("[+] [before] excute method name: {}，args empty ", methodName);
		}
	}
	
	private String getMethodName(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		if (signature != null) {
			return signature.getName();
		}
		
		return "empty method name";
	}
	
}
