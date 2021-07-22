/*
 * 
 */
package com.datn.drone.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.datn.drone.model.Role_Link;

// TODO: Auto-generated Javadoc
/**
 * The Interface Role_LinkRepository.
 */
public interface Role_LinkRepository extends MongoRepository<Role_Link,String>{
	
	/**
	 * Find Role_linksby id.
	 *
	 * @param id the id
	 * @return the role link
	 */
	Role_Link findBy_id(ObjectId id);
	
	/**
	 * Find Role_linksbyidlink.
	 *
	 * @param idlink the idlink
	 * @return the role link
	 */
	Role_Link findByidlink(String idlink);
	
	/**
	 * Find Role_linksbyidresource.
	 *
	 * @param idresource the idresource
	 * @return the list
	 */
	List<Role_Link> findByidresource(String idresource);
	
	/**
	 * Find Role_linksbycode.
	 *
	 * @param code the code
	 * @return the role link
	 */
	Role_Link findBycode(String code);

}
