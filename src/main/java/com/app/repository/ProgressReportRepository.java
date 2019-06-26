package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.model.ProgressReport;

public interface ProgressReportRepository extends MongoRepository<ProgressReport, Integer> {


	 
}
