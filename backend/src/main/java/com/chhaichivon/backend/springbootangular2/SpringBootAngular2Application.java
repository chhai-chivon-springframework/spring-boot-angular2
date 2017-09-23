package com.chhaichivon.backend.springbootangular2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
@EntityScan(basePackages = "com.chhaichivon.backend.springbootangular2.models")
@EnableJpaRepositories(basePackages = "com.chhaichivon.backend.springbootangular2.repositoties")
public class SpringBootAngular2Application{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngular2Application.class, args);
	}

}
