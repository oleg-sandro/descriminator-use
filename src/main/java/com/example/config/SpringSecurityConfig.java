package com.example.config;

import com.example.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
Spring Security configuration class
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //not sure
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(getBCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests()
                .antMatchers("/", "/signup").permitAll()
                //.antMatchers("/role/**", "/user/", "/film/**", "/hall/**", "/show/**", "/ticket/").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/user/{id}/**").access("hasRole('ADMIN') or @webSecurity.checkUserId(authentication, #id)")
                .antMatchers("/role/**", "/user/**", "/film/**", "/hall/**", "/show/**").access("hasRole('ADMIN')")
                //.antMatchers("/user/{id}/**", "/ticket/{id}/**").access("hasRole('ROLE_ADMIN') or @webSecurity.checkUserId(authentication, #id)")
                .anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/hello", false);
    }

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
