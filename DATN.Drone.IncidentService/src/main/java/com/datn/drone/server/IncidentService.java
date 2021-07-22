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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.datn.drone.controller.IncidentController;
import com.datn.drone.model.Incident;


// TODO: Auto-generated Javadoc
/**
 * The Class IncidentService.
 */
@RestController
@RequestMapping("/incidents")
public class IncidentService {
	
	/** The Incident service. */
	@Autowired
	private IncidentController IncidentService;

	/**
	 * Gets the incident.
	 *
	 * @param id the id
	 * @return the incident
	 */
	@GetMapping("/{id}")
	public Incident getIncident(@PathVariable String id) {
		Incident incident = IncidentService.getIncident(id);
		return incident;
	}

	/**
	 * Gets the all incident.
	 *
	 * @return the all incident
	 */
	@GetMapping("")
	public List<Incident> getAllIncident() {
		List<Incident> incidents = IncidentService.getAllIncident();
		return incidents;
	}
	
	/**
	 * Confirminciall.
	 *
	 * @return the string
	 */
	@GetMapping("/confirmall")
	public String confirminciall() {
		return IncidentService.confirminciall();
	}


	/**
	 * Adds the incident.
	 *
	 * @param i the i
	 * @return the response entity
	 */
	@PostMapping("")
	public ResponseEntity<String> addIncident(@RequestBody Incident i) {
		IncidentService.addIncident(i);
		return new ResponseEntity<>("Incident create successsfully", HttpStatus.OK);
	}

	/**
	 * Delete incident.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteIncident(@PathVariable String id) {
		IncidentService.deleteIncident(id);
		return new ResponseEntity<>("Incident delete successsfully", HttpStatus.OK);
	}

	/**
	 * Modify incident.
	 *
	 * @param id the id
	 * @param i the i
	 * @return the response entity
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> modifyIncident(@PathVariable("id") ObjectId id, @Valid @RequestBody Incident i) {
		IncidentService.modifyIncident(id, i);
		return new ResponseEntity<>("Incident is modified successsfully", HttpStatus.OK);
	}


	/**
	 * Gets the idpole.
	 *
	 * @param idpole the idpole
	 * @return the idpole
	 */
	@RequestMapping(value = "/idpole/{idpole}", method = RequestMethod.GET)
	public List<Incident> getidpole(@PathVariable("idpole") String idpole) {
		return IncidentService.getincipole(idpole);
	}

	/**
	 * Gets the level.
	 *
	 * @param level the level
	 * @return the level
	 */
	@RequestMapping(value = "/level/{level}", method = RequestMethod.GET)
	public List<Incident> getlevel(@PathVariable("level") String level) {
		return IncidentService.getincilevel(level);
	}

	/**
	 * Gets the status.
	 *
	 * @param status the status
	 * @return the status
	 */
	@RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
	public List<Incident> getstatus(@PathVariable("status") String status) {
		return IncidentService.getincistatus(status);
	}
}
