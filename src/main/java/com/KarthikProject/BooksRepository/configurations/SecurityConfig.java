package com.KarthikProject.BooksRepository.configurations;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeRequests((requests) -> requests
                .requestMatchers("/monitor/**","/swagger/**").permitAll()
                .requestMatchers("/books").hasRole("ADMIN")
                .anyRequest().authenticated());
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        http.cors(cors -> cors.disable());

        return http.build();

    }

 /*   @Bean
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

  */

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) throws SQLException {

        System.out.println(dataSource.getConnection());
        JdbcUserDetailsManager jdbc = new JdbcUserDetailsManager(dataSource);
        jdbc.setUsersByUsernameQuery(" Select user_name , password , active from user_details where user_name= ? ");

        jdbc.setAuthoritiesByUsernameQuery(" Select user_name , roles" +
                " from roles where user_name = ? ");
        return jdbc;
    }

//    @Bean
//    @ConditionalOnMissingBean
//    @ConditionalOnProperty(
//            name = {"springdoc.use-management-port"},
//            havingValue = "false",
//            matchIfMissing = true
//    )
//    SwaggerWelcomeWebMvc swaggerWelcome(SwaggerUiConfigProperties swaggerUiConfig, SpringDocConfigProperties springDocConfigProperties, SwaggerUiConfigParameters swaggerUiConfigParameters, SpringWebProvider springWebProvider) {
//        return new SwaggerWelcomeWebMvc(swaggerUiConfig, springDocConfigProperties, swaggerUiConfigParameters, springWebProvider);
//    }
//
//    @Bean
//    public StrictHttpFirewall httpFirewall() {
//        StrictHttpFirewall firewall = new StrictHttpFirewall();
//        firewall.setAllowedHttpMethods(Arrays.asList("GET", "POST"));
//        firewall.setAllowUrlEncodedDoubleSlash(true);
//        return firewall;
//    }

}
