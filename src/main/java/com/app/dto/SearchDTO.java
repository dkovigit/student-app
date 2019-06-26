package com.app.dto;

public class SearchDTO {
  
  private Integer userId;
  private String searchTerm;
  private Integer requestCount;
  
  
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
