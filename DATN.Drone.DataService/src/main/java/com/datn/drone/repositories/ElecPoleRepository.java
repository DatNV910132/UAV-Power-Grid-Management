/*
 * 
 */
package com.datn.drone.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.datn.drone.model.ElectricPole;

// TODO: Auto-generated Javadoc
/**
 * The Interface ElecPoleRepository.
 */
public interface ElecPoleRepository extends MongoRepository<ElectricPole, String> {
	
	/**
	 * Find ElectricPole by id.
	 *
	 * @param _id the id
	 * @return the electric pole
	 */
	ElectricPole findBy_id(ObjectId _id);
}