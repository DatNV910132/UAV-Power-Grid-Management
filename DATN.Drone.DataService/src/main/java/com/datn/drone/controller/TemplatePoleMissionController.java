/*
 * 
 */
package com.datn.drone.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.datn.drone.model.TemplatePoleMission;
import com.datn.drone.repositories.TemplatePoleMissionRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class TemplatePoleMissionController.
 */
@Service
public class TemplatePoleMissionController {

	/** The repository. */
	@Autowired
	private TemplatePoleMissionRepository repository;
	
	/**
	 * Lấy tất cả thông tin các Hành trình bay mẫu của Cột điện.
	 *
	 * @return the all temp pole miss
	 */
		public List<TemplatePoleMission> getAllTempPoleMiss() {
			return repository.findAll();
		}

		/**
		 * Lấy thông tin của Hành trình bay mẫu của Cột điện theo id đầu vào.
		 *
		 * @param id the id
		 * @return the TemplatePoleMission pole miss by id
		 */
		//
		public TemplatePoleMission getTempPoleMissById(ObjectId id) {
			return repository.findBy_id(id);
		}
		
		/**
		 * Lấy thông tin của Hành trình bay mẫu của Cột điện theo loại cột điện.
		 *
		 * @param poletype the poletype
		 * @return the TemplatePoleMission pole miss bypoletype
		 */
		public TemplatePoleMission getTempPoleMissBypoletype(String poletype) {
			return repository.findBypoletype(poletype);
		}


		/**
		 * Chỉnh sửa thông tin Hành trình bay mẫu của Cột điện.
		 *
		 * @param id the id
		 * @param TempPoleMiss the temp pole miss
		 */
		public void modifyTempPoleMissById(ObjectId id,TemplatePoleMission TempPoleMiss) {
			LocalDateTime ldt = LocalDateTime.now();
			TemplatePoleMission update = repository.findBy_id(id);
			TempPoleMiss.setCreateat(update.getCreateat());
			TempPoleMiss.set_id(id);
			TempPoleMiss.setUpdateat(ldt);
			repository.save(TempPoleMiss);
		}

		/**
		 * Tạo Hành trình bay mẫu của Cột điện mới.
		 *
		 * @param TempPoleMiss the temp pole miss
		 * @return the TemplatePoleMission pole mission
		 */
		public TemplatePoleMission createTempPoleMiss(TemplatePoleMission TempPoleMiss) {
			LocalDateTime ldt = LocalDateTime.now();
			TempPoleMiss.set_id(ObjectId.get());
			TempPoleMiss.setUpdateat(ldt);
			TempPoleMiss.setCreateat(ldt);
			repository.save(TempPoleMiss);
			return TempPoleMiss;
		}

		/**
		 * Xóa Hành trình bay mẫu của Cột điện.
		 *
		 * @param id the id
		 */
		public void deleteTempPoleMiss(ObjectId id) {
			repository.delete(repository.findBy_id(id));
		}
}
