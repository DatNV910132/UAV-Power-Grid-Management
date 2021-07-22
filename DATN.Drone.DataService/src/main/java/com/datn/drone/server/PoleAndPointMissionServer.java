/*
 * 
 */
package com.datn.drone.server;

import java.util.ArrayList;
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

import com.datn.drone.controller.Role_LinkController;
import com.datn.drone.controller.PoleAndPointMissionController;
import com.datn.drone.exception.NotFoundException;
import com.datn.drone.model.Role_Link;
import com.datn.drone.model.Point;
import com.datn.drone.model.PoleAndPointMission;

// TODO: Auto-generated Javadoc
/**
 * The Class PoleAndPointMissionServer.
 */
@RestController
@RequestMapping("/poleandpointmission")
public class PoleAndPointMissionServer {

	/** The controller. */
	@Autowired
	private PoleAndPointMissionController controller;

	/** The role linkcontroller. */
	@Autowired
	private Role_LinkController role_linkcontroller;

	/**
	 * Restful API Getsthe all.
	 *
	 * @param code the code
	 * @return the all PoleAndPointMission
	 */
	@RequestMapping(value = "/getall/", method = RequestMethod.GET)
	public List<PoleAndPointMission> getAll(@RequestParam("code") String code) {
		boolean check = false;
		List<PoleAndPointMission> PoleMissions = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			PoleMissions = controller.getAllpoleandpointmission();

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (PoleMissions == null && check) {
			throw new NotFoundException();
		}
		return PoleMissions;

	}

	/**
	 * Restful API Getsthe emp by id.
	 *
	 * @param id the id
	 * @param code the code
	 * @return the PoleAndPointMission by id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public PoleAndPointMission getEmpById(@PathVariable("id") ObjectId id, @RequestParam("code") String code) {
		boolean check = false;
		PoleAndPointMission result = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			result = controller.getpoleandpointmissionById(id);

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (result == null && check) {
			throw new NotFoundException();
		}
		return result;
	}

	/**
	 * Restful API Getsthe bypoletype.
	 *
	 * @param idpole the idpole
	 * @param code the code
	 * @return the PoleAndPointMission by idpole
	 */
	@RequestMapping(value = "/idpole/", method = RequestMethod.GET)
	public PoleAndPointMission getbypoletype(@RequestParam("idpole") String idpole, @RequestParam("code") String code) {

		boolean check = false;
		PoleAndPointMission result = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			result = controller.getpoleandpointmissionByidpole(idpole);

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (result == null && check) {
			throw new NotFoundException();
		}
		return result;

	}

	/**
	 * Restful API Modify by id.
	 *
	 * @param id the id
	 * @param poleandpointmission the poleandpointmission
	 * @param code the code
	 * @return the response entity
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> modifyById(@PathVariable("id") ObjectId id,
			@Valid @RequestBody PoleAndPointMission poleandpointmission, @RequestParam("code") String code) {

		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}

		if (check) {
			controller.modifypoleandpointmissionById(id, poleandpointmission);

		} else {
			throw new NotFoundException("Permission Denied");
		}
		return new ResponseEntity<>("Sửa thông tin hành trình thành công", HttpStatus.OK);
	}

	/**
	 * Restful API Creates the.
	 *
	 * @param poleandpointmission the poleandpointmission
	 * @param code the code
	 * @return true, if successful
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean create(@Valid @RequestBody PoleAndPointMission poleandpointmission, @RequestParam("code") String code) {

		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}

		if (check) {
			controller.createpoleandpointmission(poleandpointmission);
		} else {
			throw new NotFoundException("Permission Denied");
		}

		return true;
	}

	/**
	 * Restful API Delete.
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
			controller.deletepoleandpointmission(id);

		} else {
			throw new NotFoundException("Permission Denied");
		}

		return new ResponseEntity<>("Xóa thông tin hành trình thành công", HttpStatus.OK);
	}

	/**
	 * Createtest.
	 *
	 * @return true, if successful
	 */
	@RequestMapping(value = "/addtest", method = RequestMethod.POST)
	public boolean createtest() {

		List<Point> lp = new ArrayList<>();
		String[] tags = { "isulator", "pole" };
		Point p1 = new Point();
		p1.setLatitude(21.006699);
		p1.setLongitude(105.842961);
		p1.setHeight(2);
		p1.setAction(1);
		p1.setTags(tags);
		
		Point p2 = new Point();
		p2.setLatitude(21.006737);
		p2.setLongitude(105.843186);
		p2.setHeight(2);
		p2.setAction(1);
		p2.setTags(tags);
		
		Point p3 = new Point();
		p3.setLatitude(21.006654);
		p3.setLongitude(105.843063);
		p3.setHeight(2);
		p3.setAction(1);
		p3.setTags(tags);

		lp.add(p1);
		lp.add(p2);
		lp.add(p3);
		PoleAndPointMission pm = new PoleAndPointMission();
		pm.setName("Hành trình bay 2");
		pm.setDes("Hành trình bay với khu vực 2");
		pm.setIdpole("Test Cột điện");
		pm.setPoint(lp);

		controller.createpoleandpointmission(pm);

		return true;
	}

}
