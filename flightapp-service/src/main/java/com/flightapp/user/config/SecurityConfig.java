package com.flightapp.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.flightapp.auth.jwt.utils.AuthEntryPointJwt;
import com.flightapp.auth.service.AppUserServiceImpl;
import com.flightapp.user.fliters.JWTAuthFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AppUserServiceImpl appUserServiceImpl;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

//		httpSecurity.cors().and().csrf().disable()
//		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//		.authorizeRequests().antMatchers("/api/v1.0/auth/**").permitAll()
//		.antMatchers("/api/test/**").permitAll()
//		.anyRequest().authenticated();

//		httpSecurity.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
//				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//				.authorizeRequests().
//				antMatchers("/").permitAll();
		
		httpSecurity.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests()
		.anyRequest().authenticated();

		httpSecurity.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/v1.0/app/**", "/v1.0/user/**", "/v1.0/auth/**");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(appUserServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public JWTAuthFilter authenticationJwtTokenFilter() {
		return new JWTAuthFilter();
	}

}