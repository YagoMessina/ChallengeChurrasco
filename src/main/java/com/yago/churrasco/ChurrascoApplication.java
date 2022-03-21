package com.yago.churrasco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ChurrascoApplication {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new MessageDigestPasswordEncoder("SHA-256");
	}

	public static void main(String[] args) {
		SpringApplication.run(ChurrascoApplication.class, args);
	}
}
