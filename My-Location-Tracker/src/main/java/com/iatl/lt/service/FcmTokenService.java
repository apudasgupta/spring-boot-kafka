package com.iatl.lt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iatl.lt.model.EnvelopeResponse;
import com.iatl.lt.model.FcmTokenData;
import com.iatl.lt.repository.FcmTokenRepository;

/**
 * @author Apu Das Gupta
 *
 */
@Service
public class FcmTokenService {

	@Autowired
	private FcmTokenRepository fcmTokenRepository;

	public void insertToken(FcmTokenData fcmTokenData) {
		System.out.println("==> inserting fcmToken: " + fcmTokenData.toString());
		this.fcmTokenRepository.insert(fcmTokenData);

	}

	public EnvelopeResponse saveToken(FcmTokenData fcmTokenData) {
		EnvelopeResponse envelopeResponse=new EnvelopeResponse();
//		this.fcmTokenRepository.insert(fcmTokenData);
//		if(true)return;
		boolean registered = this.fcmTokenRepository.isRegistered(fcmTokenData.getFcmToken());
		if (registered) {
			
			this.fcmTokenRepository.update(fcmTokenData);
			envelopeResponse.setStatus(200);
			envelopeResponse.setMessage(fcmTokenData.getFcmToken());
			}
		else {
			this.fcmTokenRepository.insert(fcmTokenData);
			envelopeResponse.setStatus(200);
			envelopeResponse.setMessage(fcmTokenData.getFcmToken());
		}
		return envelopeResponse;
			

	}

	public EnvelopeResponse removeTokenFromUserAssociation(FcmTokenData fcmTokenData) {
		EnvelopeResponse envelopeResponse=new EnvelopeResponse();
		boolean registered = this.fcmTokenRepository.isRegistered(fcmTokenData.getFcmToken());
		if (registered) {			
			this.fcmTokenRepository.removeTokenFromUserAssociation(fcmTokenData);
			envelopeResponse.setStatus(200);
			envelopeResponse.setMessage("FcmToken Updated Successully !");
			}
		else {
			
			envelopeResponse.setStatus(200);
			envelopeResponse.setMessage("No result found for this token !");
		}
		return envelopeResponse;
	}

	public EnvelopeResponse getAll() {
		List<FcmTokenData> findAll = this.fcmTokenRepository.findAll();
		EnvelopeResponse envelopeResponse=new EnvelopeResponse();
		envelopeResponse.setStatus(200);
		envelopeResponse.setMessage("FCM Token List");
		envelopeResponse.setData(findAll);
		return envelopeResponse;
	}

}
