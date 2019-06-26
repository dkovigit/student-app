package com.app.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "progressreport")
public class ProgressReport {
	@Id
	private Integer userId;
	
	private Map<String, String> progressMap;

	
	
	public ProgressReport() {
		
	}
	
	public ProgressReport(Integer userId, Map<String, String> progressMap) {
		super();
		this.userId = userId;
		this.progressMap = progressMap;
	}

	

	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Map<String, String> getProgressMap() {
		return progressMap;
	}

	public void setProgressMap(Map<String, String> progressMap) {
		this.progressMap = progressMap;
	}

}
