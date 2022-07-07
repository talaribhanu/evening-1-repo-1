package com.learn.springboot.configure;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource datasource;// connects the security with the database
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	
	{
		try
		{
			PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
			
			//inMemoryAuthentication -> Stores the authentication information in the spring memory
			/*auth.inMemoryAuthentication().withUser("bhanu").password(encoder.encode("bhanu456")).roles("manager")
			.and().withUser("narendra").password(encoder.encode("narendra123")).roles("cashier");
			*/
			
			//Store the authentication information in the database
			
			auth.jdbcAuthentication().dataSource(datasource).withDefaultSchema().withUser("bhanu").password(encoder.encode("bhanu456")).roles("manager")
			.and().withUser("narendra").password(encoder.encode("narendra123")).roles("cashier");
		
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	/*@Bean
	 PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();//No Password encoding function
	}*/
	
	@Override
	
	public void configure(WebSecurity web) {
	try
	{
		// bypassing the h2 database security
		
		web.ignoring().antMatchers("/h2-console/**");
	}
	catch(Exception ex)
	{
		System.out.println(ex.getMessage());
	}
	}

}
