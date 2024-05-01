package com.KarthikProject.BooksRepository.configurations;



import com.KarthikProject.BooksRepository.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    UserService service;
    @Autowired
    PasswordEncoder encoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/monitor/**","/swagger/**").permitAll()
                .requestMatchers("/books").hasRole("ADMIN")
                .anyRequest().authenticated());
        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(AbstractHttpConfigurer::disable);

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

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService((UserDetailsService) service);
        authenticationProvider.setPasswordEncoder(encoder);
        authe
        return ;
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
