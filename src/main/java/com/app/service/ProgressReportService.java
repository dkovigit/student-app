package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.dto.ProgressReportDTO;
import com.app.exception.CustomException;
import com.app.model.ProgressReport;
import com.app.repository.ProgressReportRepository;

@Service
public class ProgressReportService {
	 @Autowired
	  private ProgressReportRepository progressRepository;

	  public void saveReport(ProgressReportDTO progressDTO) {
	    try {
	    	ModelMapper modelMapper = new ModelMapper();	    	
	    	ProgressReport progressModel = modelMapper.map(progressDTO, ProgressReport.class);
	    	progressRepository.save(progressModel);
	    	
	     } catch (RuntimeException e) {
	      throw new CustomException("Search Request Failed", HttpStatus.UNPROCESSABLE_ENTITY);
	    }
	  }
	  
	  public ProgressReportDTO getReport(Integer userId) {
		    try {
		    	ModelMapper modelMapper = new ModelMapper();
		    	ProgressReport progressModel = progressRepository.findById(userId)
		    			.orElseThrow(() -> new CustomException("Entity Not Found",  HttpStatus.INTERNAL_SERVER_ERROR));
		    	//Optional<ProgressReport> progressModel = progressRepository.findById(userId);
		    	
		    	ProgressReportDTO progressDTO = modelMapper.map(progressModel, ProgressReportDTO.class);
		    	//progressRepository.save(progressModel);
		    	return progressDTO;
		    	
		     } catch (RuntimeException e) {
		      throw new CustomException("Search Request Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		    }
		  }
	  
	  


}
