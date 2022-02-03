package com.graphql.warrantydemo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WarrantyCoverage {

	private String extendedServicePlan;

	private String warrantyStartDate;

	private String warrantyEndDate;

	private Long warrantyEndMileage;

	private RequestStatus requestStatus;
	
	private List<Value> value;

}
