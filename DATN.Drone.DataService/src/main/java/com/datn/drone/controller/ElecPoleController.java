/*
 * 
 */
package com.datn.drone.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.datn.drone.model.ElectricPole;
import com.datn.drone.repositories.ElecPoleRepository;

// TODO: Auto-generated Javadoc
/**
 * Các chức năng điều khiển của Cột điện.
 */
@Service
public class ElecPoleController {
	
	/** The repository. */
	@Autowired
	private ElecPoleRepository repository;
	
	/** The today. */
	long today = new Date().getTime();

	
	/**
	 * Lấy tất cả thông tin các Cột điện.
	 *
	 * @return the all elec poles
	 */
	public List<ElectricPole> getAllElecPoles() {
		return repository.findAll();
	}

	/**
	 * Lấy thông tin của Cột điện theo id đầu vào.
	 *
	 * @param id the id
	 * @return the elec pole by id
	 */
	public ElectricPole getElecPoleById(ObjectId id) {
		return repository.findBy_id(id);
	}

	/**
	 * Chỉnh sửa thông tin cột điện.
	 *
	 * @param id the id
	 * @param ElecPoles the elec poles
	 */
	public void modifyElecPoleById(ObjectId id,ElectricPole ElecPoles) {
		ElecPoles.set_id(id);
		repository.save(ElecPoles);
	}

	/**
	 * Tạo cột điện mới.
	 *
	 * @param ElecPoles the elec poles
	 * @return the electric pole
	 */
	public ElectricPole createElecPole(ElectricPole ElecPoles) {
		ElecPoles.set_id(ObjectId.get());
		repository.save(ElecPoles);
		return ElecPoles;
	}

	/**
	 * Xóa cột điện.
	 *
	 * @param id the id
	 */
	public void deleteElecPole(ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}
	
	/**
	 * Lấy thông tin về của cột điện quá hạn hạn bảo trì.
	 *
	 * @return the maintenance
	 */
	public List<ElectricPole> getmaintenance() {
		List<ElectricPole> lt = repository.findAll();
		List<ElectricPole> result = new ArrayList<ElectricPole>();
		long maindate;
		for (ElectricPole elecpole : lt) {
			maindate = elecpole.getEP_MaintenanceTime().getTime();
			if ((today - maindate > 0) || (today - maindate == 0)) {
				result.add(elecpole);
			}
		}
		return result;
	}

}
