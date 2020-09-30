package com.iatl.lt.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author Apu Das Gupta
 *
 */
@Data
@Entity
public class MobileLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	Long id;
	Long companyId;
	String username;
	String token;
	String latitude;
	String longitude;	
	String time;
//	String stringUtcTime;
	String stringLocalTime;
	Date localUtcDate;
	
	public void setToLocalDateTime() {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Dhaka"));
//			myDate = simpleDateFormat.parse(Long.parseLong(this.time));
			Date myDate=new Date(Long.parseLong(this.time));
			this.localUtcDate=myDate;
			this.setStringLocalTime(simpleDateFormat.format(myDate));
			
//			this.setFormattedDate(simpleDateFormat.parse(myDate.toString()));
			
//			simpleDateFormat.p
//			System.out.println("Local:" + myDate.toString() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		

	}
	
}


