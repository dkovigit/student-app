package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.dto.SearchDTO;
import com.app.dto.SearchResponseDTO;
import com.app.exception.CustomException;
import com.app.model.Search;
import com.app.repository.SearchRepository;
import com.app.service.SolrSearchService;

@Service
public class SearchService {

	 @Autowired
	  private SearchRepository searchRepository;
	 
	 @Autowired
	 SolrSearchService solrSearchService;

	  public void saveSearch(SearchDTO searchDto) {
	    try {
	    	ModelMapper modelMapper = new ModelMapper();	    	
	    	Search searchModel = modelMapper.map(searchDto, Search.class);
	    	searchRepository.save(searchModel);
	    	
	     } catch (RuntimeException e) {
	      throw new CustomException("Search Request Failed", HttpStatus.UNPROCESSABLE_ENTITY);
	    }
	  }
	  
	  
	  public SearchResponseDTO performSearch(SearchDTO searchDto) {
		    SearchResponseDTO searchResponseDto;
		  try {
			  searchResponseDto = solrSearchService.runSearch(searchDto); 
			  saveSearch(searchDto);
			  return searchResponseDto;
		     } catch (RuntimeException e) {
		      throw new CustomException("Search Request Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		    }
		  }
	  

	 
}
