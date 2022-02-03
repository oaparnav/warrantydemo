package com.graphql.warrantydemo.service;

import org.springframework.stereotype.Component;

import com.graphql.warrantydemo.model.WarrantyCoverageLookupResponse;

@Component
public class BaseWarrantyDataFetcher {

	public WarrantyCoverageLookupResponse get(String vin, String country, String language) {
		WarrantyCoverageLookupResponse response = WarrantyCoverageLookupResponse.builder()
				.url("https://dummy.com")
				.warrantyEndDate("date")
				.build();
		return response;
	}

}
