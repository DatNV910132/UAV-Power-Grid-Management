/*
 * 
 */
package com.datn.drone.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.datn.drone.model.Drone;
import com.datn.drone.repositories.DroneRepository;

// TODO: Auto-generated Javadoc
/**
 * Các chức năng điều khiển của Drone.
 */
@Service
public class DroneController {
	
	/** The repository. */
	@Autowired
	private DroneRepository repository;
	
	/** The today. */
	long today = new Date().getTime();

	/**
	 * Lấy tất cả thông tin của Drone trong hệ thống.
	 *
	 * @return the all drones
	 */
	public List<Drone> getAllDrones() {
		return repository.findAll();
	}

	/**
	 * Lấy thống tin của Drone theo đầu vào là id của Drone.
	 *
	 * @param id the id
	 * @return the drone by id
	 */
	public Drone getDroneById(ObjectId id) {
		return repository.findBy_id(id);
	}

	/**
	 * Lấy danh sách của Drone Online.
	 *
	 * @param online the online
	 * @return the dronesby online
	 */
	public List<Drone> getDronesbyOnline(boolean online) {
		return repository.findByonline(online);
	}

	/**
	 * Lấy danh sách của Drone theo lượng pin.
	 *
	 * @param battery the battery
	 * @return the dronesbybattery
	 */
	public List<Drone> getDronesbybattery(int battery) {
		return repository.findBybattery(battery);
	}

	/**
	 * Lấy danh sách Drone theo thời gian sử dụng gần nhất.
	 *
	 * @param dateuse the dateuse
	 * @return the dronesbydateuse
	 * @throws ParseException the parse exception
	 */
	public List<Drone> getDronesbydateuse(String dateuse) throws ParseException {
		List<Drone> result = new ArrayList<Drone>();
		List<Drone> lt = repository.findAll();
	    Date datefind =new SimpleDateFormat("dd-MM-yyyy").parse(dateuse);
	    Long timefind = datefind.getTime();
	    for(Drone d : lt) {
	    	long timedrone = d.getDateuse().getTime();
	    	if(timedrone - timefind <= 86400000) {
	    		result.add(d);
	    	}
	    }
		return result;
	}

	/**
	 * Lấy thông tin bảo trì của tât cả các Drone.
	 *
	 * @return the maintenance
	 */
	public List<Drone> getmaintenance() {
		List<Drone> lt = repository.findAll();
		List<Drone> result = new ArrayList<Drone>();
		long maindate;
		for (Drone drone : lt) {
			maindate = drone.getMaintenancetime().getTime();
			if ((today - maindate > 0) || (today - maindate == 0)) {
				result.add(drone);
			}
		}
		return result;
	}

	/**
	 * Cập nhật thông tin bảo trì của Drone "Bad".
	 */
	public void updatemaintenance() {
		List<Drone> lt = repository.findAll();
		long maindate;
		for (Drone drone : lt) {
			maindate = drone.getMaintenancetime().getTime();
			if ((today - maindate > 0) || (today - maindate == 0)) {
				Drone d1 = new Drone();
				d1.setName(drone.getName());
				d1.setDes(drone.getDes());
				d1.setIdman(drone.getIdman());
				d1.setMaintenancetime(drone.getMaintenancetime());
				d1.setStatus("bad");
				modifyDroneById(drone._id, d1);
			}
		}
	}

	/**
	 * Cập nhật thông tin bảo trì của Drone "Good".
	 */
	public void updatedronemaintenance() {
		List<Drone> lt = repository.findAll();
		long maindate;
		for (Drone drone : lt) {
			maindate = drone.getMaintenancetime().getTime();
			if ((today - maindate < 0) && (drone.getStatus().equals("bad"))) {
				Drone d1 = new Drone();
				d1.setName(drone.getName());
				d1.setDes(drone.getDes());
				d1.setIdman(drone.getIdman());
				d1.setMaintenancetime(drone.getMaintenancetime());
				d1.setStatus("good");
				modifyDroneById(drone._id, d1);
			}
		}
	}

	/**
	 * Cập nhật thông tin của Drone.
	 *
	 * @param id the id
	 * @param Drones the drones
	 */
	public void modifyDroneById(ObjectId id, Drone Drones) {
		Drones.set_id(id);
		repository.save(Drones);
	}

	/**
	 * Tạo mới Drone.
	 *
	 * @param Drones the drones
	 * @return the drone
	 */
	public Drone createDrone(Drone Drones) {
		Drones.set_id(ObjectId.get());
		repository.save(Drones);
		return Drones;
	}

	/**
	 * Xóa Drone khỏi hệ thống.
	 *
	 * @param id the id
	 */
	public void deleteDrone(ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}

	/**
	 * Lấy tất cả thống tin của các Drone có giống trạng thái đầu vào.
	 *
	 * @param st the st
	 * @return the dronestatus
	 */
	public List<Drone> getdronestatus(String st) {
		return repository.findBystatus(st);
	}

	/**
	 * Lấy tất cả Drone được nhân viên nào đó quản lý.
	 *
	 * @param id the id
	 * @return the dronebyidman
	 */
	public List<Drone> getdronebyidman(String id) {
		return repository.findByidman(id);
	}
}
