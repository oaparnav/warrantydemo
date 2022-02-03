package com.graphql.warrantydemo.service;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.warrantydemo.model.ExtendedWarrantyCoverageResponse;
import com.graphql.warrantydemo.model.WarrantyCoverage;
import com.graphql.warrantydemo.model.WarrantyCoverageLookupResponse;
import com.graphql.warrantydemo.model.WarrantyCoverageResponse;


public class Query implements GraphQLQueryResolver {

    private final APWarrantyDataFetcher apWarrantyDataFetcher;
	private final ExtendedWarrantyDataFetcher extendedWarrantyDataFetcher;
    private final BaseWarrantyDataFetcher baseWarrantyDataFetcher;
    private final MEandAFWarrantyDataFetcher meAndAFWarrantyDataFetcher;
    
    public Query(APWarrantyDataFetcher apWarrantyDataFetcher, ExtendedWarrantyDataFetcher extendedWarrantyDataFetcher,
			BaseWarrantyDataFetcher baseWarrantyDataFetcher, MEandAFWarrantyDataFetcher meAndAFWarrantyDataFetcher) {
		this.apWarrantyDataFetcher = apWarrantyDataFetcher;
		this.extendedWarrantyDataFetcher = extendedWarrantyDataFetcher;
		this.baseWarrantyDataFetcher = baseWarrantyDataFetcher;
		this.meAndAFWarrantyDataFetcher = meAndAFWarrantyDataFetcher;
	}


    public WarrantyCoverage fetchWarrantyForAp(String vin) {
        return apWarrantyDataFetcher.get(vin);
    }
    
    public WarrantyCoverageLookupResponse fetchBaseInfoForEU(String vin, String country, String language) {
    	return baseWarrantyDataFetcher.get(vin, country, language);
    }
    
    public ExtendedWarrantyCoverageResponse fetchExtendedInfoForEU(String vin) {
    	return extendedWarrantyDataFetcher.get(vin);
    }
    
    public WarrantyCoverageResponse fetchWarrantyMEandAF(String vin, String country) {
    	return meAndAFWarrantyDataFetcher.get(vin, country);
    }
}