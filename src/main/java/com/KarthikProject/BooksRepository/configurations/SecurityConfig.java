package com.KarthikProject.BooksRepository.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeRequests((requests) -> requests
                .requestMatchers("/","/monitor/**").permitAll()
                .anyRequest().authenticated());
        http.httpBasic(Customizer.withDefaults());
        http.csrf(customiser -> customiser.disable());

        return http.build();

    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user1=  User.builder()
                .username("Karthik")
                .password("{noop}Password")
                .roles("USER").build();

        UserDetails user2= User.builder()
                .username("ADMIN")
                .password("{noop}ADMIN")
                .roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user1,user2);
    }

    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbc = new JdbcUserDetailsManager(dataSource);
        jdbc.setUsersByUsernameQuery("Select userId,password,active from users where userId = ?");
        jdbc.setAuthoritiesByUsernameQuery("Select id,role from roles where id = ?");
        return jdbc;
    }

}
