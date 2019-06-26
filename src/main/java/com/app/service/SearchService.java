package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.dto.SearchDTO;
import com.app.exception.CustomException;
import com.app.model.Search;
import com.app.repository.SearchRepository;

@Service
public class SearchService {

	 @Autowired
	  private SearchRepository searchRepository;

	  public void saveSearch(SearchDTO searchDto) {
	    try {
	    	ModelMapper modelMapper = new ModelMapper();	    	
	    	Search searchModel = modelMapper.map(searchDto, Search.class);
	    	searchRepository.save(searchModel);
	    	
	     } catch (RuntimeException e) {
	      throw new CustomException("Search Request Failed", HttpStatus.UNPROCESSABLE_ENTITY);
	    }
	  }
	  
	  

	 
}
