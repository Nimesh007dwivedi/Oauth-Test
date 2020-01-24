package com.api.postgress.main;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//import com.api.postgress.main.files.FileStoragePO;
@SpringBootApplication
@EnableAutoConfiguration
@PropertySource(value = { "classpath:application.properties" })
@ComponentScan
public class PostgressApiMain {

	private static final Logger LOGGER = LoggerFactory.getLogger(PostgressApiMain.class);

	public static void main(String[] args) {	
		LOGGER.info("Starting SalenoAPIMain Service..!!");
		try {
			ConfigurableApplicationContext context = SpringApplication.run(PostgressApiMain.class, args);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
		return hemf.getSessionFactory();
	}
	}

