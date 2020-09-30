package com.iatl.lt.consumer.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * @author Apu Das Gupta
 *
 */
@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
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
	@Column(name="local_time")
	String stringLocalTime;
	Date localUtcDate;
	
	
	
}


