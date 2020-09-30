package com.iatl.lt.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

/**
 * @author Apu Das Gupta
 *
 */

@Data
@Entity
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
//	private Long companyId;
	private String username;
	@CreatedDate
	private Date createdAt;
	
	@ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private AppUser appUser;
	  
	
}


