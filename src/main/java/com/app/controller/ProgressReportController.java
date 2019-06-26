package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProgressReportDTO;
import com.app.service.ProgressReportService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProgressReportController {


	  @Autowired
	  private ProgressReportService progressService;
	  
	  @PostMapping("/progress")  
	  @ApiOperation(value = "progress")
	  @ApiResponses(value = {//
	      @ApiResponse(code = 400, message = "Something went wrong"), 
	      @ApiResponse(code = 422, message = "Invalid POST Request submitted")})
	  public void search(@RequestBody  ProgressReportDTO progressDTO) {	
		  progressService.saveReport(progressDTO);
	  }

	  @GetMapping("/progress/{id}")  
	  @ApiOperation(value = "progress")
	  @ApiResponses(value = {//
	      @ApiResponse(code = 400, message = "Something went wrong"), 
	      @ApiResponse(code = 422, message = "Invalid GET Request submitted")})
	  public void search(@PathVariable("id")  Integer id) {	
		  progressService.getReport(id);
	  }


}
