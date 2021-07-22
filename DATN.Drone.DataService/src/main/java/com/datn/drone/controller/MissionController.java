/*
 * 
 */
package com.datn.drone.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.drone.model.Mission;
import com.datn.drone.repositories.MissionRepository;

// TODO: Auto-generated Javadoc
/**
 * Các chức năng điều khiển quản lý hành trình bay.
 */
@Service
public class MissionController {

	/** The repository. */
	@Autowired
	private MissionRepository repository;
	
	/**
	 * Lấy tất cả thông tin các Hành trình bay.
	 *
	 * @return the all mission
	 */
		public List<Mission> getAllMission() {
			return repository.findAll();
		}

		/**
		 * Lấy thông tin của Hành trình bay theo id đầu vào.
		 *
		 * @param id the id
		 * @return the mission by id
		 */
		public Mission getMissionById(ObjectId id) {
			return repository.findBy_id(id);
		}


		/**
		 * Chỉnh sửa thông tin Hành trình bay.
		 *
		 * @param id the id
		 * @param Mission the mission
		 */
		public void modifyMissionById(ObjectId id,Mission Mission) {
			LocalDateTime now = LocalDateTime.now();
			Mission update = repository.findBy_id(id);
			Mission.setCreateat(update.getCreateat());
			Mission.set_id(id);
			Mission.setUpdateat(now);
			repository.save(Mission);
		}

		/**
		 * Tạo Hành trình bay mới.
		 *
		 * @param Mission the mission
		 * @return the mission
		 */
		public Mission createMission(Mission Mission) {
			LocalDateTime now = LocalDateTime.now();
			Mission.set_id(ObjectId.get());
			Mission.setCreateat(now);
			Mission.setUpdateat(now);
			repository.save(Mission);
			return Mission;
		}

		/**
		 * Xóa Hành trình bay.
		 *
		 * @param id the id
		 */
		public void deleteMission(ObjectId id) {
			repository.delete(repository.findBy_id(id));
		}
	
	
}
