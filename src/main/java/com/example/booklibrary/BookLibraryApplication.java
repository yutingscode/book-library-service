package com.example.booklibrary;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BookLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookLibraryApplication.class, args);
	}

}
