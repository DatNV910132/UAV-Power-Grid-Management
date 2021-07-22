/*
 * 
 */
package com.datn.drone.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.datn.drone.model.PoleAndPointMission;

// TODO: Auto-generated Javadoc
/**
 * The Interface PoleAndPointMissionRepository.
 */
public interface PoleAndPointMissionRepository extends MongoRepository<PoleAndPointMission, String> {

	/**
	 * Find PoleAndPointMission by id.
	 *
	 * @param _id the id
	 * @return the pole and point mission
	 */
	PoleAndPointMission findBy_id(ObjectId _id);
	
	/**
	 * Find PoleAndPointMission byidpole.
	 *
	 * @param idpole the idpole
	 * @return the pole and point mission
	 */
	PoleAndPointMission findByidpole(String idpole);
}
