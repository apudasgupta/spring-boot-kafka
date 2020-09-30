package com.iatl.lt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iatl.lt.model.EnvelopeResponse;
import com.iatl.lt.model.FcmTokenData;
import com.iatl.lt.service.FcmTokenService;

import io.swagger.annotations.Api;

/**
 * @author Apu Das Gupta
 *
 */

@RestController
@RequestMapping("/api/fcmToken")
@Api(tags = "FcmToken")
public class FcmTokenController {

	@Autowired
	private FcmTokenService fcmTokenService;

	@PostMapping("/saveToken")
	public EnvelopeResponse saveToken(@RequestBody FcmTokenData fcmToken) {	
		return this.fcmTokenService.saveToken(fcmToken);
		
	}
	
	@PostMapping("/removeTokenFromUserAssociation")
	public EnvelopeResponse removeTokenFromUserAssociation(@RequestBody FcmTokenData fcmToken) {
		return this.fcmTokenService.removeTokenFromUserAssociation(fcmToken);
	}
	
	@GetMapping("/getAll")
	public EnvelopeResponse getAll() {
		return this.fcmTokenService.getAll();
	}
	
	
}


