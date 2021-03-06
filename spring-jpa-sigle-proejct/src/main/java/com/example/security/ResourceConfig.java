package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
@Configuration
@EnableResourceServer
public class ResourceConfig  extends ResourceServerConfigurerAdapter{

    @Autowired
    private TokenStore tokenStore;
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        	resources.tokenStore(tokenStore);              
    }
    
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS).permitAll()
			.antMatchers("/security").hasAnyRole("USER")
			.anyRequest().permitAll();
	}
}
