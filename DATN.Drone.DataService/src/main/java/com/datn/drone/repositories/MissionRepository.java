/*
 * 
 */
package com.datn.drone.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.datn.drone.model.Mission;

// TODO: Auto-generated Javadoc
/**
 * The Interface MissionRepository.
 */
public interface MissionRepository extends MongoRepository<Mission, String> {

	/**
	 * Find Mission by id.
	 *
	 * @param _id the id
	 * @return the mission
	 */
	Mission findBy_id(ObjectId _id);
}
