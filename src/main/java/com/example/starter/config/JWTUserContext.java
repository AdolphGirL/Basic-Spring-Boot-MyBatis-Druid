package com.example.starter.config;

public final class JWTUserContext {
	
	private static final ThreadLocal<String> user = new ThreadLocal<String>();
	
	public static void add(String userName) {
		user.set(userName);
	}

	public static void remove() {
		user.remove();
	}

	public static String getCurrentUserName() {
		return user.get();
	}
}
