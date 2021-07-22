/*
 * 
 */
package com.datn.drone.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.datn.drone.model.TemplatePoleMission;

// TODO: Auto-generated Javadoc
/**
 * The Interface TemplatePoleMissionRepository.
 */
public interface TemplatePoleMissionRepository extends MongoRepository<TemplatePoleMission, String> {
	
	/**
	 * Find TemplatePoleMission by id.
	 *
	 * @param _id the id
	 * @return the template pole mission
	 */
	TemplatePoleMission findBy_id(ObjectId _id);
	
	/**
	 * Find TemplatePoleMission bypoletype.
	 *
	 * @param poletype the poletype
	 * @return the template pole mission
	 */
	TemplatePoleMission findBypoletype(String poletype);
}
