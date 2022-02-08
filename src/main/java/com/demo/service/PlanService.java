package com.demo.service;

import java.util.List;

import com.demo.binding.request.SearchRequest;
import com.demo.binding.response.PlanResponse;


public interface PlanService {

	public List<PlanResponse> search(SearchRequest request);
	public List<String> getPlanNames();
	public List<String> getPlanStatus();
	


}
