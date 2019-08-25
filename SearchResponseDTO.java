package com.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponseDTO {
	
	private SearchDTO searchDto;
	private Long numFound;
	private List<ResultSummary> resultSummaryList = new ArrayList<>();
	
	
	public SearchDTO getSearchDto() {
		return searchDto;
	}
	public void setSearchDto(SearchDTO searchDto) {
		this.searchDto = searchDto;
	}
	public Long getNumFound() {
		return numFound;
	}
	public void setNumFound(Long numFound) {
		this.numFound = numFound;
	}
	
	public List<ResultSummary> getResultSummaryList() {
		return resultSummaryList;
	}
	public void setResultSummaryList(List<ResultSummary> resultSummaryList) {
		this.resultSummaryList = resultSummaryList;
	}
	
	 

}
