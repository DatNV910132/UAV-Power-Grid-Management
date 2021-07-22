/*
 * 
 */
package com.datn.drone.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.datn.drone.model.Report;


// TODO: Auto-generated Javadoc
/**
 * The Interface ReportRepository.
 */
public interface ReportRepository extends MongoRepository<Report, String> {
	
	/**
	 * Find Report by id.
	 *
	 * @param _id the id
	 * @return the report
	 */
	Report findBy_id(ObjectId _id);
}