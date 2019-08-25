package com.app.service;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.stereotype.Service;


@Service
public class SolrClientConnect {
	
	private static volatile SolrClient solrClient;
	/*
	 * public static synchronized void init() { solrClient = new
	 * HttpSolrClient.Builder("http://localhost:8983/solr").build();
	 * 
	 * }
	 * 
	 * public SolrClient getSolrClient() { return solrClient; }
	 */
}
