package com.demo.repositories;

import java.io.Serializable;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entities.PlanEntity;

public interface PlanRepo extends JpaRepository<PlanEntity, Serializable> {
	
	
        @Query(value="select distinct planName from PlanEntity")
		public List<String> getByPlanName();
        
        @Query(value="select distinct planStatus from PlanEntity")
        public List<String> getByPlanStatus();
	
	
	
	
	

}
