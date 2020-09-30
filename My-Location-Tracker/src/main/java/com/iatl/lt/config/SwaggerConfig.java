package com.iatl.lt.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket getSwaggerConfig() {
		System.out.println("==> configuring swagger2 ---");
		return new Docket(DocumentationType.SWAGGER_2).select()                                  
//		          .apis(RequestHandlerSelectors.basePackage("com.apudasgupta.data"))  
		          .apis(RequestHandlerSelectors.any())  
		          .paths(PathSelectors.ant("/api/**"))           
//		          .paths(PathSelectors.any())                          
		          .build()
		          .apiInfo(getApiInfo()); 
	}

	private ApiInfo getApiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfo(
				"Location Tracker Api",
				"Api for Lacation Tracker App",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Apu Das Gupta", "https://github.com/apudasgupta", "great.adgupta@gmail.com"),
				"API License",
				"",
				Collections.emptyList()
				);
	}
}
