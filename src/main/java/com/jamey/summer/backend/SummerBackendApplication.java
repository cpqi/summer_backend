package com.jamey.summer.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ComponentScan("com.jamey.summer.controller")
public class SummerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SummerBackendApplication.class, args);
	}

}
