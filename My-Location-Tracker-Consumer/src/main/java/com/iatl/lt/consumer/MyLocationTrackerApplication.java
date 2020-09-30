package com.iatl.lt.consumer;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class MyLocationTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyLocationTrackerApplication.class, args);
	}
	@PostConstruct
    public void init(){
//      TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

}
