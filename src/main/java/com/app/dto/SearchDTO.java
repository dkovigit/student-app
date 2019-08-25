package com.app.dto;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchDTO {
  
  private Integer userId;
  private String searchTerm;
  private Integer requestCount;
  private Integer start;
  private String prefix;
  private Integer lengthOfTerm;
  private String country;
  private String mode;
  
  
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

  
  
  public Integer getStart() {
	return start;
}


public void setStart(Integer start) {
	this.start = start;
}


public Integer getUserId(){
	     return this.userId;
	  }
	  
   
  public void setUserId(Integer userId){
     this.userId = userId;
  }
  public String getSearchTerm(){
	     return this.searchTerm;
	  }
  public void setSearchTerm(String searchTerm){
     this.searchTerm = searchTerm;
  }

  public Integer getRequestCount(){
	     return this.requestCount;
	  }
  public void setRequestCount(Integer requestCount){
     this.requestCount = requestCount;
  }

}

