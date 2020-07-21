package com.userapp;

import com.userapp.repository.IPriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * myRetail.com Retail Management Application
 * @author kavitameena67
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class RetailManagementApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(RetailManagementApplication.class);

	public static void main(String[] args) {
		logger.info("Retail Management Application");
		SpringApplication.run(RetailManagementApplication.class, args);
	}

}
