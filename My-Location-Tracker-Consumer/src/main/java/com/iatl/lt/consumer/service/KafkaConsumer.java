package com.iatl.lt.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.iatl.lt.consumer.config.AppOptions;
import com.iatl.lt.consumer.model.MobileLocation;
import com.iatl.lt.consumer.repository.LocationRepositoryInterface;

@Service
public class KafkaConsumer {

	@Autowired
	LocationRepositoryInterface locationRepositoryInterface;

	@KafkaListener(topics = AppOptions.kafkaTopic, groupId = AppOptions.groupId, containerFactory = "locationKafkaListenerFactory")
	public void listenLocation(MobileLocation mobileLocation) {
		System.out.println("Received Messasge in Consumer App :: group - : " + AppOptions.groupId + " : " + mobileLocation);
		this.locationRepositoryInterface.save(mobileLocation);
	}

//	@KafkaListener(topics = kafkaTopic, groupId = groupId)
	public void listen(String message) {
		System.out.println("Received Messasge in Consumer App : group - : " + AppOptions.groupId + " : " + message);
	}
}
