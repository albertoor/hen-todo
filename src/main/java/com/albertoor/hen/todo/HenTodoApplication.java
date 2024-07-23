package com.albertoor.hen.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HenTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HenTodoApplication.class, args);
	}
}
