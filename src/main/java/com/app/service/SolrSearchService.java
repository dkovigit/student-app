package com.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ResultSummary;
import com.app.dto.SearchDTO;
import com.app.dto.SearchResponseDTO;

@Service
public class SolrSearchService {
//	 @SuppressWarnings("unused")
//	private SolrClient findSolrServerFromConfig() {
//		 SolrClient client;
//		 client = new HttpSolrClient.Builder("http://localhost:8983/solr/collection1").build();
//     	 return client;
//		 
//	 }
	@Autowired
	SolrClient solrClient;
	
	
	SearchResponseDTO responseDto = new SearchResponseDTO();
	List<ResultSummary> summaryList = new ArrayList<>();
	 
	
	 
	 public QueryResponse toSolrQuery(String term, Integer start, Integer rows) {
	        SolrQuery sq = new SolrQuery();
	        sq.setQuery(term);
	        sq.setStart(start);
	        sq.setRows(rows);
	       
	        try {
				return solrClient.query(sq, SolrRequest.METHOD.POST);
			} catch (SolrServerException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        return null;
	    }
	 
	 public SearchResponseDTO runSearch(SearchDTO searchDto) {
	      QueryResponse qs =  toSolrQuery(searchDto.getSearchTerm(), searchDto.getStart(), searchDto.getRequestCount());	     
	      responseDto.setSearchDto(searchDto);
	      if(qs != null) {
	    	  responseDto.setNumFound(qs.getResults().getNumFound());
	    	  for (SolrDocument d : qs.getResults()) {
	    		  ResultSummary doc = new ResultSummary();
	    		  doc.setDocId(d.get("id").toString());
	    		  doc.setQ(d.get("q").toString());
	    		  summaryList.add(doc);
	      }	    	 
	    	 responseDto.setResultSummaryList(summaryList);	    	 
	      }
	      return responseDto;
	    }
	 
	/*
	 * public SolrClient getSolrClient() { //SolrClientConnect solrConnect = new
	 * SolrClientConnect(); return solrClient.; }
	 */
}
