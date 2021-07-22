/*
 * 
 */
package com.datn.drone.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.drone.model.Notification;
import com.datn.drone.repositories.NotificationRepository;

// TODO: Auto-generated Javadoc
/**
 * Các chức năng điều khiển quản lý thông báo.
 */
@Service
public class NotificationController {

	/** The repository. */
	@Autowired
	private NotificationRepository repository;
	

		/**
		 * Lấy tất cả thông tin các Notification.
		 *
		 * @return the all notifications
		 */
		public List<Notification> getAllNotifications() {
			return repository.findAll();
		}

		/**
		 * Lấy thông tin của Notification theo id đầu vào.
		 *
		 * @param id the id
		 * @return the notification by id
		 */
		public Notification getNotificationById(ObjectId id) {
			return repository.findBy_id(id);
		}

		/**
		 * Lấy tất cả thông báo mà người nào đó với userid tạo ra.
		 *
		 * @param userid the userid
		 * @return the notibyuserid
		 */
		public List<Notification> getnotibyuserid(String userid) {
			return repository.findByuserid(userid);
		}
		
		/**
		 * lấy tất cả thông báo gửi cho một người nào đó.
		 *
		 * @param sendto the sendto
		 * @return the notibysendto
		 */
		public List<Notification> getnotibysendto(String sendto){
			return repository.findBysendto(sendto);
		}
		
		/**
		 * Lấy tất cả thông báo có cùng trạng thái.
		 *
		 * @param status the status
		 * @return the notibystatus
		 */
		public List<Notification> getnotibystatus(String status){
			return repository.findBystatus(status);
		}
		
		/**
		 * Chỉnh sửa thông tin Notification.
		 *
		 * @param id the id
		 * @param Notification the notification
		 */
		public void modifyNotificationById(ObjectId id,Notification Notification) {
			LocalDateTime now = LocalDateTime.now();
			Notification.set_id(id);
			Notification.setUpdateat(now);
			repository.save(Notification);
		}

		/**
		 * Tạo Notification mới.
		 *
		 * @param Notification the notification
		 * @return the notification
		 */
		public Notification createNotification(Notification Notification) {
			LocalDateTime now = LocalDateTime.now();
			Notification.set_id(ObjectId.get());
			Notification.setUpdateat(now);
			Notification.setCreateat(now);
			repository.save(Notification);
			return Notification;
		}

		/**
		 * Xóa Notification.
		 *
		 * @param id the id
		 */
		public void deleteNotification(ObjectId id) {
			repository.delete(repository.findBy_id(id));
		}
}
