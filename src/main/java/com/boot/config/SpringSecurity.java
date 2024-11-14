package com.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		prePostEnabled = true)
public class SpringSecurity {
	
	@Bean
	public AuthTokenFilter createBean() {
		return  new AuthTokenFilter();
	}
	
	@Bean
	protected SecurityFilterChain  filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilterBefore(createBean(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(new String[]{"/v1/slogin**","/v1/user/login","/v1/peoples","/v1/signup","/v1/signups/**"})
				.permitAll()
				.anyRequest().authenticated();
		return http.build();
	}

}
