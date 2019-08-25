package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SearchDTO;
import com.app.dto.SearchResponseDTO;
import com.app.service.SearchService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
public class SearchController {
  @Autowired
  private SearchService searchService;
  
  @PostMapping("/search")  
  @ApiOperation(value = "Search")
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), 
      @ApiResponse(code = 422, message = "Invalid Request submitted")})
  public SearchResponseDTO search(@RequestBody  SearchDTO searchRequest) {	   
    return searchService.performSearch(searchRequest);
  }



}

