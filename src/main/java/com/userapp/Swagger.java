package com.userapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {
	
	private final String BASE_PACKAGE = "com.userapp";
	private final String URL_PATH_REGEX = "/.*";
	private final String TITLE = "Spring Boot REST API";
	private final String DESCRIPTION = "Spring Boot REST API for Retail Management Application";
	private final String VERSION = "1.0";
	private final String TERMS_OF_SERVICE_URL = "Terms of service";
	private final String LICENSE = "Apache License Version 2.0";
	private final String LICENSE_URL = "https://www.apache.org/licenses/LICENSE-2.0";
	private final String CONTACT_NAME = "Kavita Meena";
	private final String CONTACT_URL = "";
	private final String CONTACT_EMAIL = "kavita.meena67@gmail.com";
		
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()                 
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.regex(URL_PATH_REGEX))
                .build()
                .apiInfo(metaData());
    }
    
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                TITLE,
                DESCRIPTION,
                VERSION,
                TERMS_OF_SERVICE_URL,
                new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_EMAIL),
                LICENSE,
                LICENSE_URL);
        return apiInfo;
    }
}
