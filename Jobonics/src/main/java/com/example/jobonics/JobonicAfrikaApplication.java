package com.example.jobonics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class JobonicAfrikaApplication {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(JobonicAfrikaApplication.class, args);
	}
}
