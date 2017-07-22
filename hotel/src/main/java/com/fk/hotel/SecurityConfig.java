package com.fk.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("fankaikai").password("123456").roles("USER");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeRequests().antMatchers("/back*").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
		.and().formLogin();
		/*.loginPage("/loginP")
		.loginProcessingUrl("/login")
		.usernameParameter("username").passwordParameter("password")
		.defaultSuccessUrl("/back")
		.failureUrl("/login/failure");*/
		
	}
}
