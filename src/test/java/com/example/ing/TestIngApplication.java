package com.example.ing;

import org.springframework.boot.SpringApplication;

public class TestIngApplication {

	public static void main(String[] args) {
		SpringApplication.from(IngApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
