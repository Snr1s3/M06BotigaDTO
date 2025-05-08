package com.accesadades.botiga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.accesadades.botiga")
public class BotigaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotigaApplication.class, args);
	}
}