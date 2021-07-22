/*
 * 
 */
package com.datn.drone.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.drone.model.Link;
import com.datn.drone.repositories.LinkRepository;

// TODO: Auto-generated Javadoc
/**
 * Các chức năng điều khiển quản lý các API.
 */
@Service
public class LinkController {

	/** The repository. */
	@Autowired
	private LinkRepository repository;
	
	/**
	 * Lấy tất cả thông tin các Link.
	 *
	 * @return the all links
	 */
		public List<Link> getAllLinks() {
			return repository.findAll();
		}

		/**
		 * Lấy thông tin của Link theo id đầu vào.
		 *
		 * @param id the id
		 * @return the link by id
		 */
		public Link getLinkById(ObjectId id) {
			return repository.findBy_id(id);
		}

		/**
		 * Lấy thông tin của Link thông qua tên của Link.
		 *
		 * @param url the url
		 * @return Link by url
		 */
		public Link getbyurl(String url) {
			return repository.findByurl(url);
		}
		
		/**
		 * Chỉnh sửa thông tin Link.
		 *
		 * @param id the id
		 * @param Link the link
		 */
		public void modifyLinkById(ObjectId id,Link Link) {
			LocalDateTime now = LocalDateTime.now();
			Link.set_id(id);
			Link.setUpdateat(now);
			repository.save(Link);
		}

		/**
		 * Tạo Link mới.
		 *
		 * @param Link the link
		 * @return the link
		 */
		public Link createLink(Link Link) {
			LocalDateTime now = LocalDateTime.now();
			Link.set_id(ObjectId.get());
			Link.setCreateat(now);
			Link.setUpdateat(now);
			repository.save(Link);
			return Link;
		}

		/**
		 * Xóa Link.
		 *
		 * @param id the id
		 */
		public void deleteLink(ObjectId id) {
			repository.delete(repository.findBy_id(id));
		}
		
}
