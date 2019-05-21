package com.javatechie.spring.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
/*
 * crossOrigin on class level
 * 
 * @CrossOrigin(origins="http://localhost:9090")
 */
/*
 * crossOrigin on method level with all origin *
 * 
 * @CrossOrigin(origins="*")
 */
public class MyportalApplication {

	/*
	 * crossOrigin on method level
	 * 
	 * @CrossOrigin(origins="http://localhost:9090")
	 */
	@GetMapping("/access")
	public String greeting() {
		return "Welcome to javatechie portal";
	}

	public static void main(String[] args) {
		SpringApplication.run(MyportalApplication.class, args);
	}

	/*
	 * We can add this poc for global config
	 */ @Bean
	public WebMvcConfigurer configure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("http://localhost:9090");
			}
		};
	}
}
