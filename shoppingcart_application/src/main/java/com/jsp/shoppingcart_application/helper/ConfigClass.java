package com.jsp.shoppingcart_application.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {
	@Bean
	public EntityManagerFactory getEmf() {
		return Persistence.createEntityManagerFactory("dev");

	}

}
