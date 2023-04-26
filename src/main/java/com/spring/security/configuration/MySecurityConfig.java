package com.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	//ROLE- high level overview(normal-READ)
	//Authority-permission-READ
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		
		//To send CSRF token and acces POST and PUT method
		//.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		//.and()
		.authorizeRequests()
		.antMatchers("/welcome").hasRole("NORMAL")
		//.antMatchers("/users/new").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		//.httpBasic();
		
		//For form based authentication
		.formLogin();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Twinki K").password(this.passwordEncoder().encode("Twinki@2001")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("Annu K").password("Annu@2001").roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		//To use the password as it
		//return NoOpPasswordEncoder.getInstance();
		
		//To encode the password
		return new BCryptPasswordEncoder(10);
	}
	
	
}
