package com.graphql.warrantydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.graphql.warrantydemo.service.APWarrantyDataFetcher;
import com.graphql.warrantydemo.service.BaseWarrantyDataFetcher;
import com.graphql.warrantydemo.service.ExtendedWarrantyDataFetcher;
import com.graphql.warrantydemo.service.MEandAFWarrantyDataFetcher;
import com.graphql.warrantydemo.service.Query;

@Configuration
public class GraphqlConfiguration {

	@Bean
	public Query graphqlQuery(APWarrantyDataFetcher apWarrantyDataFetcher, 
							ExtendedWarrantyDataFetcher extendedWarrantyDataFetcher,
							BaseWarrantyDataFetcher baseWarrantyDataFetcher,
							MEandAFWarrantyDataFetcher meAndAFWarrantyDataFetcher) {
		return new Query(apWarrantyDataFetcher, 
				extendedWarrantyDataFetcher, 
				baseWarrantyDataFetcher, meAndAFWarrantyDataFetcher);
	}
	

}
