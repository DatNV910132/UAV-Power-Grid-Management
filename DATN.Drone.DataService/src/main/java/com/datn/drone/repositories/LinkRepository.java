/*
 * 
 */
package com.datn.drone.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.datn.drone.model.Link;


// TODO: Auto-generated Javadoc
/**
 * The Interface LinkRepository.
 */
public interface LinkRepository extends MongoRepository<Link, String> {
	
	/**
	 * Find Link by id.
	 *
	 * @param _id the id
	 * @return the link
	 */
	Link findBy_id(ObjectId _id);
	
	/**
	 * Find Link byurl.
	 *
	 * @param url the url
	 * @return the link
	 */
	Link findByurl(String url);

}
