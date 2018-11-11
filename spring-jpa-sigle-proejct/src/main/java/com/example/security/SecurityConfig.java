package com.example.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/*@Configuration
@EnableWebSecurity*/
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	//httpBasic() - 브라우저 로그인
	//formLogin() - 로그인 페이지
/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) 
      throws Exception {
        auth.inMemoryAuthentication()
          .withUser("john").password("123").roles("CLIENT");
    }*/
 
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() 
      throws Exception {
        return super.authenticationManagerBean();
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable().cors();
    	http.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS).permitAll();
    	 http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
/*		http.authorizeRequests()
		.antMatchers("/security").hasAnyRole("ROLE_USER")
		.anyRequest().permitAll();	*/
    }
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedHeader("*");
		
		configuration.addAllowedMethod("*");
		configuration.addAllowedOrigin("*");
		configuration.addExposedHeader("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
    
	
//    @Bean
//    public FilterRegistrationBean corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        source.registerCorsConfiguration("/**", config);
//        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//        bean.setOrder(0);
//        return bean;
//    }

    /* To allow Pre-flight [OPTIONS] request from browser */


    
}
