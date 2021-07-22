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

import com.datn.drone.controller.MissionController;
import com.datn.drone.controller.Role_LinkController;
import com.datn.drone.exception.NotFoundException;
import com.datn.drone.model.Mission;
import com.datn.drone.model.Role_Link;

// TODO: Auto-generated Javadoc
/**
 * The Class MissionServer.
 */
@RestController
@RequestMapping("/mission")
public class MissionServer {

	/** The controller. */
	@Autowired
	private MissionController controller;

	/** The role linkcontroller. */
	@Autowired
	private Role_LinkController role_linkcontroller;

	/**
	 * Restful API Gets the all.
	 *
	 * @param code the code
	 * @return the all Mission
	 */
	@RequestMapping(value = "/getall/", method = RequestMethod.GET)
	public List<Mission> getAll(@RequestParam("code") String code) {
		boolean check = false;
		List<Mission> Missions = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			Missions = controller.getAllMission();

		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (Missions == null && check) {
			throw new NotFoundException();
		}
		return Missions;

	}

	/**
	 * Restful API Gets the Mission by id.
	 *
	 * @param id the id
	 * @param code the code
	 * @return the Mission by id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Mission getMissionById(@PathVariable("id") ObjectId id, @RequestParam("code") String code) {
		boolean check = false;
		Mission result = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}
		if (check) {
			result = controller.getMissionById(id);

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
	 * @param Mission the mission
	 * @param code the code
	 * @return the response entity
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> modifyById(@PathVariable("id") ObjectId id, @Valid @RequestBody Mission Mission,
			@RequestParam("code") String code) {

		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}

		if (check) {
			controller.modifyMissionById(id, Mission);

		} else {
			throw new NotFoundException("Permission Denied");
		}
		return new ResponseEntity<>("Sửa thông tin hành trình thành công", HttpStatus.OK);
	}

	/**
	 * Restful API Creates the.
	 *
	 * @param Mission the mission
	 * @param code the code
	 * @return true, if successful
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean create(@Valid @RequestBody Mission Mission, @RequestParam("code") String code) {

		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);

		if (role_links != null) {
			check = true;
		}

		if (check) {
			controller.createMission(Mission);
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
			controller.deleteMission(id);

		} else {
			throw new NotFoundException("Permission Denied");
		}

		return new ResponseEntity<>("Xóa thông tin hành trình thành công", HttpStatus.OK);
	}

//	/**
//	 * Createtest.
//	 */
//	@RequestMapping(value = "/addtest", method = RequestMethod.POST)
//	public void createtest() {
//		Mission m = new Mission();
//		m.setName("Test");
//		m.setDes("test");
//		m.setAutoFlightSpeed(0f);
//		m.setMaxFlightSpeed(10f);
//		m.setSetExitMissionOnRCSignalLostEnabled(false);
//		m.setFinishedAction(1);
//		m.setFlightPathMode(1);
//		m.setGotoFirstWaypointMode(1);
//		m.setHeadingMode(1);
//		m.setRepeatTimes(1);
//		
//		List<String> ls = new ArrayList<>();
//		ls.add("1");
//		ls.add("2");
//		ls.add("3");
//		m.setPoleandpointmission(ls);
//		
//		controller.createMission(m);
//	}

}
