package com.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "search")
public class Search {

	@Id
	private Integer userId;
	private String searchTerm;	
	private Integer  requestCount;
	private Integer start;
	  private String prefix;
	  private Integer lengthOfTerm;
	  private String country;
	  private String mode;
	  
	
	  public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public Integer getLengthOfTerm() {
		return lengthOfTerm;
	}
	public void setLengthOfTerm(Integer lengthOfTerm) {
		this.lengthOfTerm = lengthOfTerm;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}

	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer id) {
		this.userId = id;
	}
	public String getSearchTerm() {
		return this.searchTerm;
	}
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	public Integer getRequestCount() {
		return this.requestCount;
	}
	public void setRequestCount(Integer requestCount) {
		this.requestCount = requestCount;
	}
}


