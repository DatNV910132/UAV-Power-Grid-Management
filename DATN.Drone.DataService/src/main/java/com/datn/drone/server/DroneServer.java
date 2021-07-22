/*
 * 
 */
package com.datn.drone.server;

import java.text.ParseException;
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
import com.datn.drone.controller.DroneController;
import com.datn.drone.controller.Role_LinkController;
import com.datn.drone.exception.NotFoundException;
import com.datn.drone.model.Drone;
import com.datn.drone.model.Role_Link;

// TODO: Auto-generated Javadoc
/**
 * The Class DroneServer.
 */
@RestController
@RequestMapping("/drones")
public class DroneServer {
	
	/** The drone controller. */
	@Autowired
	private DroneController droneController;

	/** The role linkcontroller. */
	@Autowired
	private Role_LinkController role_linkcontroller;

	/**
	 * Restful API Gets the all drones.
	 *
	 * @param code the code
	 * @return the all drones
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Drone> getAllDrones(@RequestParam("code") String code) {

		boolean check = false;
		List<Drone> drones = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			drones = droneController.getAllDrones();

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (drones == null && check) {
			throw new NotFoundException();
		}
		return drones;

	}

	/**
	 * Restful API Gets the all drone by Status.
	 *
	 * @param status the status
	 * @param code the code
	 * @return the all drones
	 */
	@RequestMapping(value = "/status/", method = RequestMethod.GET)
	public List<Drone> getAllMain(@RequestParam("status") String status, @RequestParam("code") String code) {
		
		boolean check = false;
		List<Drone> drones = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			drones = droneController.getdronestatus(status);

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (drones == null && check) {
			throw new NotFoundException();
		}
		return drones;
		
	}

	/**
	 * Restful API Gets the alldrone by idman.
	 *
	 * @param idman the idman
	 * @param code the code
	 * @return the alldronebyidman
	 */
	@RequestMapping(value = "/idman/", method = RequestMethod.GET)
	public List<Drone> getalldronebyidman(@RequestParam("idman") String idman, @RequestParam("code") String code) {
		
		boolean check = false;
		List<Drone> drones = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			drones = droneController.getdronebyidman(idman);

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (drones == null && check) {
			throw new NotFoundException();
		}
		return drones;
	
	}

	/**
	 * Restful API Gets the drone by ID.
	 *
	 * @param id the id
	 * @param code the code
	 * @return the drone
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Drone getDrone(@PathVariable("id") ObjectId id, @RequestParam("code") String code) {
		
		boolean check = false;
		Drone drone = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			drone = droneController.getDroneById(id);

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (drone == null && check) {
			throw new NotFoundException();
		}
		return drone;
		
	}
	
	/**
	 * Restful API Gets the drones by battery.
	 *
	 * @param battery the battery
	 * @param code the code
	 * @return the dronesbybattery
	 */
	@RequestMapping(value = "/battery/", method = RequestMethod.GET)
	public List<Drone> getdronesbybattery(@RequestParam("battery") int battery, @RequestParam("code") String code) {
		
		boolean check = false;
		List<Drone> drones = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			drones = droneController.getDronesbybattery(battery);

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (drones == null && check) {
			throw new NotFoundException();
		}
		return drones;
	
	}
	
	/**
	 * Restful API Gets the drones by dateuse.
	 *
	 * @param dateuse the dateuse
	 * @param code the code
	 * @return the dronesbydateuse
	 * @throws ParseException the parse exception
	 */
	@RequestMapping(value = "/dateuse/", method = RequestMethod.GET)
	public List<Drone> getdronesbydateuse(@RequestParam("dateuse") String dateuse, @RequestParam("code") String code) throws ParseException {
		
		boolean check = false;
		List<Drone> drones = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			drones = droneController.getDronesbydateuse(dateuse);

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (drones == null && check) {
			throw new NotFoundException();
		}
		return drones;
	
	}
	
	/**
	 * Restful API Gets the alldrone by online.
	 *
	 * @param online the online
	 * @param code the code
	 * @return the alldronebyonline
	 */
	@RequestMapping(value = "/online/", method = RequestMethod.GET)
	public List<Drone> getalldronebyonline(@RequestParam("online") boolean online, @RequestParam("code") String code) {
		
		boolean check = false;
		List<Drone> drones = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			drones = droneController.getDronesbyOnline(online);

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (drones == null && check) {
			throw new NotFoundException();
		}
		return drones;
	
	}

	/**
	 * Restful API Gets the.
	 *
	 * @param code the code
	 * @return the list
	 */
	@RequestMapping(value = "/getmaintenance", method = RequestMethod.GET)
	public List<Drone> get(@RequestParam("code") String code) {
		
		boolean check = false;
		List<Drone> drones = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			drones = droneController.getmaintenance();

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (drones == null && check) {
			throw new NotFoundException();
		}
		return drones;
		
	}

	/**
	 * Update bad maintenance.
	 *
	 * @param code the code
	 * @return the response entity
	 */
	@RequestMapping(value = "/updatebadmain", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			droneController.updatemaintenance();

		} else {
			throw new NotFoundException("Permission Denied");
		}	
		
		return new ResponseEntity<>("Drone Status is upadate successsfully", HttpStatus.OK);
	}

	/**
	 * Update good maintenance drone.
	 *
	 * @param code the code
	 * @return the response entity
	 */
	@RequestMapping(value = "/updategoodmain", method = RequestMethod.PUT)
	public ResponseEntity<String> updatedrone(@RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			droneController.updatedronemaintenance();

		} else {
			throw new NotFoundException("Permission Denied");
		}	
		
		return new ResponseEntity<>("Drone Status is update successsfully", HttpStatus.OK);
	}

	/**
	 * Restful API Modify drone.
	 *
	 * @param id the id
	 * @param Drones the drones
	 * @param code the code
	 * @return the response entity
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> modifyDrone(@PathVariable("id") ObjectId id, @Valid @RequestBody Drone Drones, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			droneController.modifyDroneById(id, Drones);

		} else {
			throw new NotFoundException("Permission Denied");
		}	
		
		return new ResponseEntity<>("Drone is modified successsfully", HttpStatus.OK);
	}

	/**
	 * Restful API Creates the drone.
	 *
	 * @param Drones the drones
	 * @param code the code
	 * @return the drone
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Drone create(@Valid @RequestBody Drone Drones, @RequestParam("code") String code) {
		
		boolean check = false;
		Drone drone = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			drone = droneController.createDrone(Drones);

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (drone == null && check) {
			throw new NotFoundException();
		}
		return drone;
		
	}

	/**
	 * Restful API Delete drone.
	 *
	 * @param id the id
	 * @param code the code
	 * @return the response entity
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable ObjectId id, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			droneController.deleteDrone(id);

		} else {
			throw new NotFoundException("Permission Denied");
		}	

		return new ResponseEntity<>("Drone is deleted successsfully", HttpStatus.OK);
	}
}
