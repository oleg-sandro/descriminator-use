//package com.example.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.*;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(users.username("marina").password("password").roles("USER").build());
//        manager.createUser(users.username("oleg").password("password").roles("USER", "ADMIN").build());
//        return manager;
//    }
//}


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
                .antMatchers("/*", "/hello", "/reg").permitAll()
                .antMatchers("/role/**", "/user/").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/user/{id}/**").access("hasRole('ROLE_ADMIN') or @webSecurity.checkUserId(authentication, #id)")
                //.antMatchers("/").authenticated()
                //.anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/hello", false);
    }

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
////        return new UserDetailsServiceImpl();
//        UserDetails userDetails =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("pass")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }

//    @Bean
//    public DaoAuthenticationProviderImpl authenticationProvider() {
//        return new DaoAuthenticationProviderImpl();
//    }

}
