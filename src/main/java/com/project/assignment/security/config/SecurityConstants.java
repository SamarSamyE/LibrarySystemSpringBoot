package com.project.assignment.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class SecurityConstants {

	public static String tokenSecret;

	private static String loginTokenSecretKey;

	@Autowired
	public SecurityConstants(Environment environment) {
		tokenSecret = environment.getProperty("token.secret");
		loginTokenSecretKey = environment.getProperty("login.token.secret.key");
	}

	public static String getTokenSecret() {
		return tokenSecret;
	}

	public static String getLoginTokenSecretKey() {
		return loginTokenSecretKey;
	}

	public static final long EXPIRATION_TIME = 864000000; // 10 DAYS IN MILLI SECONDES
	public static final long PASSWORD_REST_EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour IN MILLI SECONDES

	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";


}