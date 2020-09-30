package com.iatl.lt.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iatl.lt.consumer.model.MobileLocation;

/**
 * @author Apu Das Gupta
 *
 */

@Repository
public interface LocationRepositoryInterface extends JpaRepository<MobileLocation, Long>{
	MobileLocation save(MobileLocation mobileLocation);
}


