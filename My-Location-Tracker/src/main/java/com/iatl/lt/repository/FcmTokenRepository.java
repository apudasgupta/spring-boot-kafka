package com.iatl.lt.repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iatl.lt.mapper.FcmTokenRowMapper;
import com.iatl.lt.model.FcmTokenData;
import com.iatl.lt.model.MobileLocation;

/**
 * @author Apu Das Gupta
 *
 */

@Repository
public class FcmTokenRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int insertLocation(MobileLocation mobileLocation) {
		String sql = "insert into bg_trackings(company_id,username,token,latitude,longitude,mover_utc_time) "
				+ " values(?,?,?,?,?,?)";
		return this.jdbcTemplate.update(sql, mobileLocation.getCompanyId(), mobileLocation.getUsername(),
				mobileLocation.getToken(), mobileLocation.getLatitude(), mobileLocation.getLongitude(),
				mobileLocation.getTime());

	}

	public int insert(FcmTokenData fcmToken) {
		System.out.println("==> inserting FcmTokenData: "+fcmToken.toString());
		String sql = "insert into fcm_tokens(username,device_unique_id,device_model,fcm_token)   values(?,?,?,?)";
		return this.jdbcTemplate.update(sql, 
				fcmToken.getUsername(), 
				fcmToken.getDeviceUniqueId(),
				fcmToken.getDeviceModel(),
				fcmToken.getFcmToken());
	}

	public int update(FcmTokenData fcmToken) {
		System.out.println("==> updating FcmTokenData: "+fcmToken.toString());
		String sql = "update fcm_tokens set"
				+ " username=?,"
				+ " device_unique_id=?,"
				+ " device_model=? " 
				+ " where fcm_token=? ";
		return this.jdbcTemplate.update(sql, fcmToken.getUsername(), fcmToken.getDeviceUniqueId(),
				fcmToken.getDeviceModel(), fcmToken.getFcmToken());
	}

	public FcmTokenData findByToken(String fcmToken) {
		System.out.println("==> finding fcmToken: "+fcmToken);
		String sql = "select * from fcm_tokens where fcm_token = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { fcmToken }, new FcmTokenRowMapper());

	}
	public boolean isRegistered(String fcmToken) {
		String sql = "select id from fcm_tokens where fcm_token = ?";
		boolean hasRecord = jdbcTemplate.query(sql, new Object[] {fcmToken }, (ResultSet rs) -> {
			if (rs.next()) {
				return true;
			}
			return false;
		});

		return hasRecord;
	}

	public int removeTokenFromUserAssociation(FcmTokenData fcmTokenData) {
		System.out.println("==> removeTokenFromUserAssociation: "+fcmTokenData.toString());
		String sql = "update fcm_tokens set"
				+ " username=null"				 
				+ " where fcm_token=? ";
		return this.jdbcTemplate.update(sql, fcmTokenData.getFcmToken());
		
	}

	public List<FcmTokenData> findAll() { 
		System.out.println("==> finding fcmToken all: ");
		String sql = "select * from fcm_tokens";
		return jdbcTemplate.query(sql, new FcmTokenRowMapper());

	}

	

}
