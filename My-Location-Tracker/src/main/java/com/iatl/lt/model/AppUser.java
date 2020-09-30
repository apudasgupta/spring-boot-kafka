package com.iatl.lt.model;



import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

/**
 * @author Apu Das Gupta
 *
 */

@Data
@Entity
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyId;
	private String name;
	private String password;
	@CreatedDate
	private Date createdAt;
	
	@OneToMany(mappedBy="appUser")
    private Set<UserInfo> users;

}
