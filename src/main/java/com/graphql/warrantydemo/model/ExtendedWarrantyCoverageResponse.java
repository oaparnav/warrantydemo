package com.graphql.warrantydemo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExtendedWarrantyCoverageResponse {

	private LocalDateTime contractExpirationDate;
	private BigDecimal contractExpirationDistanceMeasure;
	private String termPeriodMonths;
	private String contractType;
	private String mileageUnit;
}
