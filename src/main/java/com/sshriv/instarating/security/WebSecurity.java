package com.sshriv.instarating.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurity  extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	BCryptPasswordEncoder bcrypt;
	
	@Autowired
	UserDetailsService userdetails;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.httpBasic().and().authorizeRequests().antMatchers("/users/user").hasRole("USER");
		http.httpBasic().and().authorizeRequests().antMatchers("/users/user/*").hasRole("USER");
		http.httpBasic().and().authorizeRequests().antMatchers("/users/admin").hasRole("ADMIN");
		
	}

	
	@Bean
	protected UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager= new InMemoryUserDetailsManager();
		manager.createUser(User.builder().username("Rahul").password(bcrypt.encode("user-pass")).roles("USER").build());
		manager.createUser(User.builder().username("Shriv").password(bcrypt.encode("user-admin")).roles("ADMIN").build());
		//JdbcUserDetailsManager jdbc =new JdbcUserDetailsManager();
		
		return  manager;
		
	}
	

	
}
