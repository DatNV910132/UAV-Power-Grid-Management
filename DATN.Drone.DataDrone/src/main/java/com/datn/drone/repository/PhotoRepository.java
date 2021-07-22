/*
 * 
 */
package com.datn.drone.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.datn.drone.model.Photo;

// TODO: Auto-generated Javadoc
/**
 * The Interface PhotoRepository.
 */
public interface PhotoRepository extends MongoRepository<Photo, String> {
	
	/**
	 * Find byidpole.
	 *
	 * @param idpole the idpole
	 * @return the list
	 */
	List<Photo> findByidpole(String idpole);
	
	/**
	 * Find bydate import.
	 *
	 * @param dateimport the dateimport
	 * @return the list
	 */
	List<Photo> findBydateImport(String dateimport);
	
	/**
	 * Find bydate create.
	 *
	 * @param datecreate the datecreate
	 * @return the list
	 */
	List<Photo> findBydateCreate(String datecreate);
	
	/**
	 * Find byiddrone.
	 *
	 * @param iddrone the iddrone
	 * @return the list
	 */
	List<Photo> findByiddrone(String iddrone);
	
	/**
	 * Find bycrop.
	 *
	 * @param crop the crop
	 * @return the list
	 */
	List<Photo> findBycrop(boolean crop);
	
	/**
	 * Find bytitle.
	 *
	 * @param title the title
	 * @return the list
	 */
	List<Photo> findBytitle(String title);
	
}
