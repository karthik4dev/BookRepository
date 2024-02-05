package com.KarthikProject.BooksRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Book Application",
					version = "1.0"
,description = "This application is used as Book Repository",
contact = @Contact(name = "Karthik P N",email = "karthikpnrao.97@gmail.com")))
@SpringBootApplication
public class BooksRepositoryApplication {



	public static void main(String[] args) {
		Thread.yield();
		SpringApplication.run(BooksRepositoryApplication.class, args);
	}



}
