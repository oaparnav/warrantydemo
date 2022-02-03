package com.graphql.warrantydemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.graphql.warrantydemo.model.RequestStatus;
import com.graphql.warrantydemo.model.Value;
import com.graphql.warrantydemo.model.WarrantyCoverage;


@Component
public class APWarrantyDataFetcher {

	public WarrantyCoverage get(String vin) {
		
		List<Value> value = new ArrayList<>();
		value.add(Value.builder().name("Sham").type("Software").build());
		value.add(Value.builder().name("Ram").type("Software").build());
		value.add(Value.builder().name("Ravi").type("Associate").build());
		value.add(Value.builder().name("Kumar").type("Software").build());
		value.add(Value.builder().name("kavitha").type("Techinical").build());
		
		WarrantyCoverage response = WarrantyCoverage.builder().extendedServicePlan("Mock plan")
															  .warrantyStartDate("10/08/2020")
															  .warrantyEndDate("19/8/2020")
															  .warrantyEndMileage(10L)
															  .requestStatus(RequestStatus.CURRENT)
															  .value(value)
															  .build();
															 
		return response;
	}

}
