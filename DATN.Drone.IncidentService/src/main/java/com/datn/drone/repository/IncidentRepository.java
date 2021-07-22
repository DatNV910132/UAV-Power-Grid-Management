/*
 * 
 */
package com.datn.drone.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.datn.drone.model.Incident;

// TODO: Auto-generated Javadoc
/**
 * The Interface IncidentRepository.
 */
public interface IncidentRepository extends MongoRepository<Incident, String> {
	
	/**
	 * Find by id.
	 *
	 * @param _id the id
	 * @return the incident
	 */
	Incident findBy_id(ObjectId _id);
	
	/**
	 * Find bystatus.
	 *
	 * @param status the status
	 * @return the list
	 */
	//Incident findByidpole(String idpole);
	List<Incident> findBystatus(String status);
	
	/**
	 * Find bylevel.
	 *
	 * @param level the level
	 * @return the list
	 */
	List<Incident> findBylevel(String level);
	
	/**
	 * Find byidpole.
	 *
	 * @param idpole the idpole
	 * @return the list
	 */
	List<Incident> findByidpole(String idpole);

}
