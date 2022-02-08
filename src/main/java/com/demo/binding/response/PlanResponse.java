package com.demo.binding.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanResponse {
	
	private Integer planId;
	
	private String planName;
	
	private String holderName;
	
	private Integer holderSsn;
	
	private String planStatus;

}
