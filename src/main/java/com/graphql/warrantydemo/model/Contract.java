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
public class Contract {
	private String contractExpirationDate;
    private String contractExpirationDistanceMeasure;
    private String termPeriodMonths;
    private String coverageStart;
    private String contractPlanCode;
    private String contractProductName;
    private String contractProductDescription;
    private String planCountryCode;
    private String mileageUnit;
    private String contractState;
    private String contractBusinessStatus;
    private String contractID;
    private String planYear;
    private String nmbrOfRemainingServices;
    private String nmbrOfPurchasedServices;
    private String purchaserName;
    private List<String> driverName;
    private String deductible;
    private String currencyCode;
    private String coverageStartDate;
    private String contractSignatureDate;
    private String contractStartDistance;
    private List<String> options;
    private String roadSideAssistance;
    private String rentalAmount;
    private String rentalDays;
}
