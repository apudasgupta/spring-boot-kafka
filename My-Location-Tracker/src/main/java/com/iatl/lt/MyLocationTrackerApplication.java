package com.iatl.lt;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class MyLocationTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyLocationTrackerApplication.class, args);
//		String[] availableIDs = TimeZone.getAvailableIDs();
//
//		for (String id : availableIDs) {
//			System.out.println("Timezone = " + id);
//		}
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

}
