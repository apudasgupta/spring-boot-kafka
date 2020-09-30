package com.iatl.lt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iatl.lt.model.MobileLocation;

/**
 * @author Apu Das Gupta
 *
 */

public interface LocationRepositoryInterface extends JpaRepository<MobileLocation, Long>{

}


