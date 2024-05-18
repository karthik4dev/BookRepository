package com.karthikProject.Authserver;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
<<<<<<< HEAD
@EnableDiscoveryClient
=======
@OpenAPIDefinition(info = @Info(title = "Authentication Server",contact = @Contact(name = "Karthik P N",email = "Karthikpnrao.97@Gmail.com"),version = "1.1",description = "Used to authenticate and authorize the users",termsOfService = "Please make sure it is used by owner's approval"))
>>>>>>> a0fb9a00129d46598ffb8a2c08cfc18a20bb2847
public class AuthServerApplication {
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

}
