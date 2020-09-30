package com.iatl.lt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iatl.lt.model.EnvelopeResponse;
import com.iatl.lt.model.MobileLocation;
import com.iatl.lt.service.LocationService;

import io.swagger.annotations.Api;

/**
 * @author Apu Das Gupta
 *
 */

@RestController
@RequestMapping("/api/locationTracker")
@Api(tags = "LocationTracker")
public class LocationTrackerController {

	
	

	@Autowired
	private LocationService locationService;

	@Autowired
	private SimpMessagingTemplate template;

	@PostMapping("/insertLocation")
	public EnvelopeResponse insertLocation(@RequestBody List<MobileLocation> mobileLocationData) {
		System.out.println("==> size: " + mobileLocationData.size());

		this.locationService.insertLocation(mobileLocationData);
		EnvelopeResponse envelopeResponse = new EnvelopeResponse();
		envelopeResponse.setStatus(200);
		envelopeResponse.setMessage("Location Inserted");
		this.template.convertAndSend("/topic/greetings", mobileLocationData);
		
		return envelopeResponse;
	}

	@GetMapping("/getLastLocationOfUser")
	public EnvelopeResponse getLastLocationOfUser(@RequestParam long companyId, @RequestParam String username) {
		System.out.println("==> getLastLocationOfUser: " + companyId + "-" + username);
		MobileLocation mobileLocation = this.locationService.getCurrentLocationByCompanyIdAndUserName(companyId,
				username);
		EnvelopeResponse envelopeResponse = new EnvelopeResponse();
		envelopeResponse.setStatus(200);
		envelopeResponse.setMessage("User Last Location");
		envelopeResponse.setData(mobileLocation);
		return envelopeResponse;
	}

	public EnvelopeResponse getFallback() {
		EnvelopeResponse envelopeResponse = new EnvelopeResponse();
		envelopeResponse.setStatus(500);
		envelopeResponse.setMessage("Internal Server Error");
		envelopeResponse.setData(null);
		return envelopeResponse;
	}

}
