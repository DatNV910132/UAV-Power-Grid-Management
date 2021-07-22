/*
 * 
 */
package com.datn.drone.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.datn.drone.model.Notification;

// TODO: Auto-generated Javadoc
/**
 * The Interface NotificationRepository.
 */
public interface NotificationRepository extends MongoRepository<Notification, String> {

	/**
	 * Find  Notificationby id.
	 *
	 * @param _id the id
	 * @return the notification
	 */
	Notification findBy_id(ObjectId _id);
	
	/**
	 * Find  Notificationbyuserid.
	 *
	 * @param userid the userid
	 * @return the list
	 */
	List<Notification> findByuserid(String userid);
	
	/**
	 * Find  Notificationbysendto.
	 *
	 * @param sendto the sendto
	 * @return the list
	 */
	List<Notification> findBysendto(String sendto);
	
	/**
	 * Find  Notificationbystatus.
	 *
	 * @param status the status
	 * @return the list
	 */
	List<Notification> findBystatus(String status);
	
}
