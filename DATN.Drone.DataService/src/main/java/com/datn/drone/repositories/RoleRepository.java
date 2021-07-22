/*
 * 
 */
package com.datn.drone.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.datn.drone.model.Role;


// TODO: Auto-generated Javadoc
/**
 * The Interface RoleRepository.
 */
public interface RoleRepository extends MongoRepository<Role, String> {
	
	/**
	 * Find Role by id.
	 *
	 * @param _id the id
	 * @return the role
	 */
	Role findBy_id(ObjectId _id);
	
	/**
	 * Find Role byrolename.
	 *
	 * @param rolename the rolename
	 * @return the role
	 */
	Role findByrolename(String rolename);

}
