package com.app.dto;

import java.util.Map;


public class ProgressReportDTO {
	
	private Integer userId;
	
	private Map<String, String> progressMap;

	
	
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
