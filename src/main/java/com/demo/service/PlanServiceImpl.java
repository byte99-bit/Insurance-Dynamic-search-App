package com.demo.service;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.demo.binding.request.SearchRequest;
import com.demo.binding.response.PlanResponse;
import com.demo.entities.PlanEntity;
import com.demo.repositories.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService
{

	@Autowired
	PlanRepo repo;

	@Override
	public List<PlanResponse> search(SearchRequest request) {
		PlanEntity entity=new PlanEntity();
		
		
		if(request!=null && request.getPlanName()!=null && !request.getPlanName().equals(""))
		{entity.setPlanName(request.getPlanName());}
		
		if(request!=null && request.getPlanStatus()!=null && !request.getPlanStatus().equals(""))
		{entity.setPlanStatus(request.getPlanStatus());}
		
		Example<PlanEntity> output = Example.of(entity);
		List<PlanEntity> list=repo.findAll(output);
		List<PlanResponse> plan=new ArrayList<>();
		for(PlanEntity ent:list)
		{
			
			PlanResponse res=new PlanResponse();
			BeanUtils.copyProperties(ent, res);
			plan.add(res);
			
		}
		return plan;
	}

	@Override
	public List<String> getPlanNames() {
		List<String> planname = repo.getByPlanName();
		
		return planname;
	}

	@Override
	public List<String> getPlanStatus() {
		List<String> planstatus = repo.getByPlanStatus();
		return planstatus;
	}
	 
	
}