package com.crm.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.crm.Services.CustomUserDetailsServices;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private CustomUserDetailsServices userDetails;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request.requestMatchers("/home").permitAll().anyRequest().authenticated())
				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults())
				.build();
	}
	
	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		System.err.println("Inside authentication provider");
		DaoAuthenticationProvider daProvider = new DaoAuthenticationProvider();
		daProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		daProvider.setUserDetailsService(userDetails);
		
		return daProvider;
	}
	
	/*
	 * @Bean 
	 * public UserDetailsService getUserDetailsService() { UserDetails user =
	 * User.withDefaultPasswordEncoder() .username("rohit@gmail.com")
	 * .password("1234") .roles("Admin") .build();
	 * 
	 * return new InMemoryUserDetailsManager(user); }
	 */
}
