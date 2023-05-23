package com.bs23.MvcSecuriyt.MvcSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    // add support for jdbc ..
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests((configurer) ->
                configurer
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/customer/**").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
        ).formLogin(form ->
                form
                        .loginPage("/showLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
        ).logout(logout -> logout.permitAll())
                .exceptionHandling(configurer->
                        configurer.accessDeniedPage("/access-denied"));

        return httpSecurity.build();
    }

    //    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails zahid = User.builder()
//                .username("zahid")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//        UserDetails tonmoy = User.builder()
//                .username("tonmoy")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(zahid, tonmoy);
//    }
}
