package com.iatl.lt.consumer.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iatl.lt.consumer.model.MobileLocation;

/**
 * @author Apu Das Gupta
 *
 */
@Repository
public class LocationRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;	

	public int insertLocation(MobileLocation mobileLocation) {
		String sql="insert into bg_trackings(company_id,username,token,latitude,longitude,mover_utc_time) "
				+ " values(?,?,?,?,?,?)";
		return this.jdbcTemplate.update(sql, mobileLocation.getCompanyId(),mobileLocation.getUsername(),
				mobileLocation.getToken(),mobileLocation.getLatitude(),mobileLocation.getLongitude(),
				mobileLocation.getTime());
		
	}
	
}


