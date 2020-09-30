package com.iatl.lt.consumer.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

/**
 * @author Apu Das Gupta
 *
 */

@Data
@Entity(name="fcm_tokens")
public class FcmTokenData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;	
	
	String username;	
	String deviceUniqueId;
	String deviceModel;
	String fcmToken;	
	@Column(name="is_active", columnDefinition="boolean default true")
	Boolean isActive;
	
	@CreatedDate
	Date createdAt;
	
	
	public void setPropertyFromResultSet(ResultSet rs) throws SQLException {
		this.setUsername(rs.getString("username"));
		this.setDeviceUniqueId(rs.getString("device_unique_id"));
		this.setDeviceModel(rs.getString("device_model"));
		this.setFcmToken(rs.getString("fcm_token"));
	}
}


