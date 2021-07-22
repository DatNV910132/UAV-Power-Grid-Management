/*
 * 
 */
package com.datn.drone.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.datn.drone.model.Drone;

// TODO: Auto-generated Javadoc
/**
 * The Interface DroneRepository.
 */
public interface DroneRepository extends MongoRepository<Drone, String> {
	
	/**
	 * Find Drone or List Droneby id.
	 *
	 * @param _id the id
	 * @return Drone
	 */
	Drone findBy_id(ObjectId _id);
	
	/**
	 * Find Drone or List Dronebystatus.
	 *
	 * @param status the status
	 * @return the list drones
	 */
	List<Drone> findBystatus(String status);
	
	/**
	 * Find Drone or List Dronebyidman.
	 *
	 * @param id the id
	 * @return the list drones
	 */
	List<Drone> findByidman(String id);
	
	/**
	 * Find Drone or List Dronebyonline.
	 *
	 * @param online the online
	 * @return the list drones
	 */
	List<Drone> findByonline(boolean online);
	
	/**
	 * Find Drone or List Dronebybattery.
	 *
	 * @param battery the battery
	 * @return the list drones
	 */
	List<Drone> findBybattery(int battery);
	
	/**
	 * Find Drone or List Drone bydateuse.
	 *
	 * @param dateuse the dateuse
	 * @return the list drones
	 */
	List<Drone> findBydateuse(String dateuse);
}