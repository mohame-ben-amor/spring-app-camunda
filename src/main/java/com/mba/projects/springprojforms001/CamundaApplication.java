package com.mba.projects.springprojforms001;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@SpringBootApplication
@EnableProcessApplication("springprojforms001")
public class CamundaApplication {

  public static void main(String... args) {
    SpringApplication.run(CamundaApplication.class, args);
    }
  
  	
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
    	CorsConfiguration configuration = new CorsConfiguration();
    	configuration.setAllowCredentials(true);
    	configuration.addAllowedOrigin("*");
    	configuration.addAllowedHeader("authorization,"+"content-type,"
    			+ "access-control-request-headers,"
    			+ "access-control-request-method,"
    			+ "accept,"
    			+ "Origin,"
    			+ "authorization,"
    			+ "x-requested-with");
    	configuration.addAllowedMethod("*");
    	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	source.registerCorsConfiguration("/**", configuration);
    	return source;
    
    
    
  }

}
