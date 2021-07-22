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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.datn.drone.controller.ElecPoleController;
import com.datn.drone.controller.Role_LinkController;
import com.datn.drone.exception.NotFoundException;
import com.datn.drone.model.ElectricPole;
import com.datn.drone.model.Role_Link;

// TODO: Auto-generated Javadoc
/**
 * The Class ElecPoleServer.
 */
@RestController
@RequestMapping("/electricpoles")
public class ElecPoleServer {

	/** The elecpole controller. */
	@Autowired
	private ElecPoleController elecpoleController;

	/** The role linkcontroller. */
	@Autowired
	private Role_LinkController role_linkcontroller;

	/**
	 * Restful API Gets the all elec poles.
	 *
	 * @param code the code
	 * @return the all elec poles
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<ElectricPole> getAllElecPoles(@RequestParam("code") String code) {

		boolean check = false;
		List<ElectricPole> electricpoles = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			electricpoles = elecpoleController.getAllElecPoles();

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (electricpoles == null && check) {
			throw new NotFoundException();
		}
		return electricpoles;

	}

	/**
	 * Restful API Gets the.
	 *
	 * @param code the code
	 * @return the list
	 */
	@RequestMapping(value = "/getmaintenance", method = RequestMethod.GET)
	public List<ElectricPole> get(@RequestParam("code") String code) {

		boolean check = false;
		List<ElectricPole> electricpoles = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			electricpoles = elecpoleController.getmaintenance();

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (electricpoles == null && check) {
			throw new NotFoundException();
		}
		return electricpoles;

	}

	/**
	 * Restful API Gets the elec pole by id.
	 *
	 * @param id the id
	 * @param code the code
	 * @return the elec pole by id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ElectricPole getElecPoleById(@PathVariable("id") ObjectId id, @RequestParam("code") String code) {

		boolean check = false;
		ElectricPole electricpole = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			electricpole = elecpoleController.getElecPoleById(id);

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (electricpole == null && check) {
			throw new NotFoundException();
		}
		return electricpole;

	}

	/**
	 * Restful API Modify elec pole by id.
	 *
	 * @param id the id
	 * @param ElecPoles the elec poles
	 * @param code the code
	 * @return the response entity
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> modifyElecPoleById(@PathVariable("id") ObjectId id,
			@Valid @RequestBody ElectricPole ElecPoles, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			elecpoleController.modifyElecPoleById(id, ElecPoles);

		} else {
			throw new NotFoundException("Permission Denied");
		}

		return new ResponseEntity<>("Sửa thông tin cột điện thành công", HttpStatus.OK);
	}

	/**
	 * Restful API Creates the elec pole.
	 *
	 * @param ElecPoles the elec poles
	 * @param code the code
	 * @return the electric pole
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ElectricPole createElecPole(@Valid @RequestBody ElectricPole ElecPoles, @RequestParam("code") String code) {
		
		boolean check = false;
		ElectricPole electricpole = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			electricpole = elecpoleController.createElecPole(ElecPoles);

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (electricpole == null && check) {
			throw new NotFoundException();
		}
		return electricpole;
		
	}

	/**
	 * Restful API Delete elec pole.
	 *
	 * @param id the id
	 * @param code the code
	 * @return the response entity
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteElecPole(@PathVariable ObjectId id, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			elecpoleController.deleteElecPole(id);
		} else {
			throw new NotFoundException("Permission Denied");
		}
				
		return new ResponseEntity<>("Xóa Cột điện thành công", HttpStatus.OK);
	}
}
