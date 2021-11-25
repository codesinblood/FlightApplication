//package com.flightapp.airlines.config;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//
//		// Disabling CORS. Post requests are authorized by default.
//		httpSecurity = httpSecurity.csrf().disable();
//
//		httpSecurity.authorizeRequests().antMatchers("/").permitAll();
//	}
//
//}