package com.example.orderswift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class OrderswiftApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderswiftApplication.class, args);
	}

}