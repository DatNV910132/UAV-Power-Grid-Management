/*
 * 
 */
package com.datn.drone.server;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datn.drone.controller.NotificationController;
import com.datn.drone.exception.NotFoundException;
import com.datn.drone.model.Notification;

// TODO: Auto-generated Javadoc
/**
 * The Class NotificationServer.
 */
@RestController
@RequestMapping("/notifications")
public class NotificationServer {

	/** The noticontroller. */
	@Autowired
	private NotificationController noticontroller;
	
	/**
	 * Gets the all notifications.
	 *
	 * @return the all notifications
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	private List<Notification> getAllNotifications() {
		List<Notification> Notifications = noticontroller.getAllNotifications();

		if (Notifications == null) {
			throw new NotFoundException();
		}
		return Notifications;
	}
	
	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private Notification getById(@PathVariable("id") ObjectId id) {
		Notification Notification = noticontroller.getNotificationById(id);

		if (Notification == null) {
			throw new NotFoundException();
		}
		return Notification;
	}
	
	/**
	 * Gets the byuser id.
	 *
	 * @param userid the userid
	 * @return the byuser id
	 */
	@RequestMapping(value = "/userid/", method = RequestMethod.GET)
	private List<Notification> getByuserId(@RequestParam("userid") String userid) {
		List<Notification> Notifications = noticontroller.getnotibyuserid(userid);

		if (Notifications == null) {
			throw new NotFoundException();
		}
		return Notifications;
	}

	/**
	 * Gets the bysendto.
	 *
	 * @param sendto the sendto
	 * @return the bysendto
	 */
	@RequestMapping(value = "/sendto/", method = RequestMethod.GET)
	private List<Notification> getBysendto(@RequestParam("sendto") String sendto) {
		List<Notification> Notifications = noticontroller.getnotibysendto(sendto);

		if (Notifications == null) {
			throw new NotFoundException();
		}
		return Notifications;
	}
	
	/**
	 * Gets the bystatus.
	 *
	 * @param status the status
	 * @return the bystatus
	 */
	@RequestMapping(value = "/status/", method = RequestMethod.GET)
	private List<Notification> getBystatus(@RequestParam("status") String status) {
		List<Notification> Notifications = noticontroller.getnotibystatus(status);

		if (Notifications == null) {
			throw new NotFoundException();
		}
		return Notifications;
	}
	
	/**
	 * Modify notification by id.
	 *
	 * @param id the id
	 * @param Notification the notification
	 * @return the response entity
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	private ResponseEntity<String> modifyNotificationById(@PathVariable("id") ObjectId id,
			@Valid @RequestBody Notification Notification) {
		noticontroller.modifyNotificationById(id, Notification);
		return new ResponseEntity<>("Sửa thông tin Notification thành công", HttpStatus.OK);
	}

	/**
	 * Creates the notification.
	 *
	 * @param Notification the notification
	 * @return the notification
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	private Notification createNotification(@Valid @RequestBody Notification Notification) {
		return noticontroller.createNotification(Notification);
	}

	/**
	 * Delete notification.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	private ResponseEntity<String> deleteNotification(@PathVariable ObjectId id) {
		noticontroller.deleteNotification(id);
		return new ResponseEntity<>("Xóa Notification thành công", HttpStatus.OK);
	}
}
