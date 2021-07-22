/*
 * 
 */
package com.datn.drone.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.drone.model.PoleAndPointMission;
import com.datn.drone.repositories.PoleAndPointMissionRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PoleAndPointMissionController.
 */
@Service
public class PoleAndPointMissionController {

	/** The repository. */
	@Autowired
	private PoleAndPointMissionRepository repository;
	
	/**
	 * Lấy tất cả thông tin các Hành trình bay của Cột điện.
	 *
	 * @return the all pole miss
	 */
		public List<PoleAndPointMission> getAllpoleandpointmission() {
			return repository.findAll();
		}

		/**
		 * Lấy thông tin của Hành trình bay của Cột điện theo id đầu vào.
		 *
		 * @param id the id
		 * @return the PoleAndPointMission by id
		 */
		public PoleAndPointMission getpoleandpointmissionById(ObjectId id) {
			return repository.findBy_id(id);
		}
		
		/**
		 * Lấy thông tin của Hành trình bay của Cột điện theo loại cột điện.
		 *
		 * @param idpole the idpole
		 * @return the PoleAndPointMission by idpole
		 */
		public PoleAndPointMission getpoleandpointmissionByidpole(String idpole) {
			return repository.findByidpole(idpole);
		}


		/**
		 * Chỉnh sửa thông tin Hành trình bay của Cột điện.
		 *
		 * @param id the id
		 * @param poleandpointmission the poleandpointmission
		 */
		public void modifypoleandpointmissionById(ObjectId id,PoleAndPointMission poleandpointmission) {
			LocalDateTime now = LocalDateTime.now();
			PoleAndPointMission update = repository.findBy_id(id);
			poleandpointmission.setCreateat(update.getCreateat());
			poleandpointmission.set_id(id);
			poleandpointmission.setUpdateat(now);
			repository.save(poleandpointmission);
		}

		/**
		 * Tạo Hành trình bay của Cột điện mới.
		 *
		 * @param poleandpointmission the poleandpointmission
		 * @return the pole and point mission
		 */
		public PoleAndPointMission createpoleandpointmission(PoleAndPointMission poleandpointmission) {
			LocalDateTime now = LocalDateTime.now();
			poleandpointmission.set_id(ObjectId.get());
			poleandpointmission.setCreateat(now);
			poleandpointmission.setUpdateat(now);
			repository.save(poleandpointmission);
			return poleandpointmission;
		}

		/**
		 * Xóa Hành trình bay của Cột điện.
		 *
		 * @param id the id
		 */
		public void deletepoleandpointmission(ObjectId id) {
			repository.delete(repository.findBy_id(id));
		}
	
}
