package com.huylv.order_management_system;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.huylv.order_management_system.service.OrderService;

@SpringBootApplication
public class OrderManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(OrderService orderService) {
		return args -> {
			System.out.println("Bean class: " + orderService.getClass());
			orderService.outerTest();
			orderService.innerTest();
		};
	}
}