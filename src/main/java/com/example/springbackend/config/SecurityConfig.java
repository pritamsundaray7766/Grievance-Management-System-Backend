package com.example.springbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // Publicly accessible paths
                .antMatchers("/public/**").permitAll()
                // User API accessible to all authenticated users
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN", "STAKEHOLDER")
                // Admin API accessible only to users with ADMIN role
                .antMatchers("/admin/**").hasRole("ADMIN")
                // Stakeholder API accessible only to users with STAKEHOLDER role
                .antMatchers("/stakeholder/**").hasRole("STAKEHOLDER")
                .anyRequest().authenticated()
                .and()
                .httpBasic(); // Use HTTP Basic authentication
    }
}
