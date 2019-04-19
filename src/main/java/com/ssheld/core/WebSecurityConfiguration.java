package com.ssheld.core;

import com.ssheld.user.DetailsService;
import com.ssheld.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Author: Stephen Sheldon 4/19/2019
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Autowired
  DetailsService userDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService)
        // Method to let security know how to decode the password
        .passwordEncoder(User.PASSWORD_ENCODER);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Below code is just for example, NOT production (Don't turn csrf off in production!!!)
    http
        // Say any request must be authenticated
        .authorizeRequests()
          .anyRequest().authenticated()
        .and()
        .httpBasic()
        .and()
          .csrf().disable();
  }
}
