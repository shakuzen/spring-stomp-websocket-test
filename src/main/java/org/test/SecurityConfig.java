package org.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * Created on: 2014/10/19
 * @author Tommy
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.httpBasic()
        	.and()
            //Configures url based authorization
        	.authorizeRequests()
        		// Anyone can access the urls
        		.antMatchers("/").permitAll()
                //The rest of the our application is protected.
                .antMatchers("/**").authenticated();
    }
    
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("testuser").password("testpass").roles("USER").and()
				.withUser("adminuser").password("adminpass").roles("ADMIN","USER");
	}

}
