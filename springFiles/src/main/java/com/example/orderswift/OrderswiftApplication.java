package com.example.orderswift;

import com.example.orderswift.controller.OrderController;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class OrderswiftApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(OrderswiftApplication.class)
				.headless(false)
				.web(WebApplicationType.NONE)
				.run(args);

//		SpringApplication.run(OrderswiftApplication.class, args);
	}

}