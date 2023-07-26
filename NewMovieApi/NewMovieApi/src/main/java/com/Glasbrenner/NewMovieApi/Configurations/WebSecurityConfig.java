package com.Glasbrenner.NewMovieApi.Security;


import com.Glasbrenner.NewMovieApi.Security.APIUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    @Autowired
    DataSource dataSource;

    @Autowired
    private CustomAuthenticationProvider authProvider;
    @Bean
    public UserDetailsService userDetailsService(){
        return new APIUserService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder.authenticationProvider(authProvider);

        return authenticationManagerBuilder.build();
    }
   @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
       http
               .authorizeHttpRequests((authorize) -> authorize
                       .requestMatchers("/","/login","/logout").permitAll()
                       .requestMatchers("/api", "/api/**").hasRole("USER")
               )
               .httpBasic(Customizer.withDefaults())
               .formLogin(Customizer.withDefaults());
       // @formatter:on
       return http.build();
   }



}
