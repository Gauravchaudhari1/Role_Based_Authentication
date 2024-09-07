package com.Security_Registration_App.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    public CustomAuthSucessHandler sucessHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService getDetailsService() {

        return new CustomParentDetailService();
    }

    @Bean
    public DaoAuthenticationProvider getDaoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(getDetailsService());

        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // http.csrf().disable().authorizeHttpRequests().requestMatchers("/", "/signin",
        // "/register", "/saveParent")
        // .permitAll()
        // .requestMatchers("/parent/**")
        // .authenticated().and().formLogin().loginPage("/signin").loginProcessingUrl("/parentLogin")
        // .defaultSuccessUrl("/parent/profile").permitAll();

        http.csrf().disable()
                .authorizeHttpRequests().requestMatchers("/parent/**").hasRole("USER")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/**").permitAll().and()
                .formLogin().loginPage("/signin").loginProcessingUrl("/parentLogin")
                .successHandler(sucessHandler)
                .permitAll();

        return http.build();

    }

}
