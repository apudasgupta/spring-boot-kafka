package com.iatl.lt.service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.iatl.lt.model.MobileLocation;
import com.iatl.lt.repository.LocationRepository;

/**
 * @author Apu Das Gupta
 *
 */
@Service
public class LocationService {

	private final ConcurrentHashMap<String, MobileLocation> hmCurrentLocation=new ConcurrentHashMap<>();
	
//	private static final String kafkaTopic="location-info";
	private static final String kafkaTopic="mylocation";
	
	@Autowired
	private KafkaTemplate<String, MobileLocation> kafkaTemplate;

	public void sendMessage(MobileLocation msg) {
		kafkaTemplate.send(kafkaTopic, msg);
	}
	
	@Autowired
	private LocationRepository locationRepository;
//	@Autowired
//	private LocationRepositoryInterface locationRepositoryInterface;

	public void insertLocation(List<MobileLocation> mobileLocationData) {
		for (MobileLocation mobileLocation : mobileLocationData) {
			System.out.println("==> mobileLocationData: " + mobileLocation.toString());
			mobileLocation.setToLocalDateTime();
			System.out.println("==> mobileLocationData: " + mobileLocation.toString());
//			this.locationRepository.insertLocation(mobileLocation);
//			this.locationRepositoryInterface.save(mobileLocation);
			this.addCurrentLocation(mobileLocation);
			this.sendMessage(mobileLocation);
			
		}

	}
	
	public void addCurrentLocation(MobileLocation mobileLocation) {
		hmCurrentLocation.put(mobileLocation.getCompanyId()+":"+mobileLocation.getUsername(), mobileLocation);
		System.out.println("==> hmCurrentLocation.size: "+hmCurrentLocation.size());
	}
	public MobileLocation getCurrentLocationByCompanyIdAndUserName(MobileLocation mobileLocation) {
		return hmCurrentLocation.get(mobileLocation.getCompanyId()+":"+mobileLocation.getUsername());
	}
	public MobileLocation getCurrentLocationByCompanyIdAndUserName(Long companyId, String userName) {
		return hmCurrentLocation.get(companyId+":"+userName);
	}

	public void getLastLocationOfUser(long companyId, String username) {
		// TODO Auto-generated method stub
		
	}
	

}
