package com.chhaichivon.backend.springbootangular2;

import com.chhaichivon.backend.springbootangular2.models.Category;
import com.chhaichivon.backend.springbootangular2.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.*;

@SpringBootApplication
@EntityScan(basePackages = "com.chhaichivon.backend.springbootangular2.models")
@EnableJpaRepositories(basePackages = "com.chhaichivon.backend.springbootangular2.repositoties")
public class SpringBootAngular2Application{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAngular2Application.class, args);
	}

}
