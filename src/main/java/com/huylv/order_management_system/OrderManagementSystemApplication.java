package com.huylv.order_management_system;

import javax.crypto.SecretKey;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.huylv.order_management_system.application.service.OrderService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;

@SpringBootApplication
public class OrderManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementSystemApplication.class, args);
	}

	@Bean
	String secretKeyString() {
		SecretKey key = Jwts.SIG.HS256.key().build(); // Tạo key ngẫu nhiên an toàn cho HS256
		String secretString = Encoders.BASE64.encode(key.getEncoded()); // Chuyển sang chuỗi Base64
		System.out.println(secretString);
		return secretString;
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