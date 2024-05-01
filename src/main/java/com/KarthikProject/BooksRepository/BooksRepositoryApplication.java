package com.KarthikProject.BooksRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@OpenAPIDefinition(info = @Info(title = "Book Application",
					version = "1.0"
,description = "This application is used as Book Repository",
contact = @Contact(name = "Karthik P N",email = "karthikpnrao.97@gmail.com")))
@SpringBootApplication
@EnableDiscoveryClient
//@EnableCaching
public class BooksRepositoryApplication {

	@Bean
	public PasswordEncoder getPassWordEncoder(){
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		SpringApplication.run(BooksRepositoryApplication.class, args);
	}





}
