/*
 * 
 */
package com.datn.drone.controller;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.datn.drone.model.Incident;
import com.datn.drone.repository.IncidentRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class IncidentController.
 */
@Service
public class IncidentController {

	/** The Incident repo. */
	@Autowired
	private IncidentRepository IncidentRepo;

	/**
	 * Gets the all incident.
	 *
	 * @return the all incident
	 */
	//lấy tất cả thông tin về sự cố
	public List<Incident> getAllIncident() {
		return IncidentRepo.findAll();
	}

	/**
	 * Gets the incident.
	 *
	 * @param id the id
	 * @return the incident
	 */
	//Lấy sự cố theo id đầu vào
	public Incident getIncident(String id) {
		return IncidentRepo.findById(id).get();
	}

	/**
	 * Adds the incident.
	 *
	 * @param incident the incident
	 */
	//Thêm sự cố
	public void addIncident(Incident incident){
		incident.set_id(ObjectId.get());
		IncidentRepo.save(incident);
	}

	/**
	 * Delete incident.
	 *
	 * @param id the id
	 */
	//Xóa sự cố
	public void deleteIncident(String id) {
		IncidentRepo.deleteById(id);
	}

	/**
	 * Modify incident.
	 *
	 * @param id the id
	 * @param i the i
	 */
	//Sửa sự cố
	public void modifyIncident(ObjectId id, Incident i) {
		i.set_id(id);
		IncidentRepo.save(i);
	}

	/**
	 * Gets the incistatus.
	 *
	 * @param status the status
	 * @return the incistatus
	 */
	//Lấy sự cố theo status
	public List<Incident> getincistatus(String status) {
		return IncidentRepo.findBystatus(status);
	}
	
	/**
	 * Gets the incilevel.
	 *
	 * @param level the level
	 * @return the incilevel
	 */
	//Lấy sự cố theo level
	public List<Incident> getincilevel(String level){
		return IncidentRepo.findBylevel(level);
	}
	
	/**
	 * Gets the incipole.
	 *
	 * @param idpole the idpole
	 * @return the incipole
	 */
	//Lấy sự cố theo cột điện
	public List<Incident> getincipole(String idpole){
		return IncidentRepo.findByidpole(idpole);
	}
	
	/**
	 * Confirminciall.
	 *
	 * @return the string
	 */
	//Confirm tất cả các sự cố đang chờ duyệt
	public String confirminciall() {
		List<Incident> listinci = IncidentRepo.findBystatus("wait");
		for(Incident incident : listinci) {
			incident.setStatus("norepair");
			IncidentRepo.save(incident);
		}
		
		return "successful";
	}
}
