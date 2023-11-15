package com.Library.LibraryManage.mentSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Library.LibraryManage.mentSystem.service.BookService;
import com.Library.LibraryManage.mentSystem.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	  @Bean
	    public CommandLineRunner demo(BookService bookService, UserService userService) {
	        return args -> {
	            // Initialize data or perform any startup tasks
	        };
	    }

}
