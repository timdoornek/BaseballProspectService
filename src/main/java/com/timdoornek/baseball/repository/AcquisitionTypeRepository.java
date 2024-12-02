package com.timdoornek.baseball.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timdoornek.baseball.domain.AcquisitionType;


public interface AcquisitionTypeRepository extends JpaRepository<AcquisitionType, String>{
    
}
