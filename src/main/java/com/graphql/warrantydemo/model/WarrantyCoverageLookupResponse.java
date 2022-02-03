package com.graphql.warrantydemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WarrantyCoverageLookupResponse {
	private String url;
	private String warrantyEndDate;
}
