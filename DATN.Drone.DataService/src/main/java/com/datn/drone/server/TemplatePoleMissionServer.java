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
import com.datn.drone.controller.TemplatePoleMissionController;
import com.datn.drone.exception.NotFoundException;
import com.datn.drone.model.TemplatePoleMission;
import com.datn.drone.model.Point;
import com.datn.drone.model.Role_Link;

// TODO: Auto-generated Javadoc
/**
 * The Class TemplatePoleMissionServer.
 */
@RestController
@RequestMapping("/templatepolemission")
public class TemplatePoleMissionServer {
	
	/** The controller. */
	@Autowired
	private TemplatePoleMissionController controller;
	
	/** The role linkcontroller. */
	@Autowired
	private Role_LinkController role_linkcontroller;

	/**
	 * Restful API Gets the all.
	 *
	 * @param code the code
	 * @return the all TemplatePoleMission
	 */
	@RequestMapping(value = "/getall/", method = RequestMethod.GET)
	public List<TemplatePoleMission> getAll(@RequestParam("code") String code) {
		boolean check = false;
		List<TemplatePoleMission> TemplatePoleMissions = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		if(check) {
			TemplatePoleMissions = controller.getAllTempPoleMiss();
			
		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (TemplatePoleMissions == null && check) {
			throw new NotFoundException();
		}
		return TemplatePoleMissions;
		
	}

	/**
	 * Restful API Gets the emp by id.
	 *
	 * @param id the id
	 * @param code the code
	 * @return the TemplatePoleMission by id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TemplatePoleMission getEmpById(@PathVariable("id") ObjectId id,@RequestParam("code") String code) {
		boolean check = false;
		TemplatePoleMission result = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		if(check) {
			result = controller.getTempPoleMissById(id);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (result == null && check) {
			throw new NotFoundException();
		}
		return result;
	}
	
	/**
	 * Restful API Gets the bypoletype.
	 *
	 * @param poletype the poletype
	 * @param code the code
	 * @return the TemplatePoleMission bypoletype
	 */
	@RequestMapping(value = "/poletype/", method = RequestMethod.GET)
	public TemplatePoleMission getbypoletype(@RequestParam("poletype") String poletype, @RequestParam("code") String code) {
		
		boolean check = false;
		TemplatePoleMission result = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		if(check) {
			result = controller.getTempPoleMissBypoletype(poletype);
			
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
	 * @param TemplatePoleMission the template pole mission
	 * @param code the code
	 * @return the response entity
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> modifyById(@PathVariable("id") ObjectId id,
			@Valid @RequestBody TemplatePoleMission TemplatePoleMission, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		
		if(check) {
			controller.modifyTempPoleMissById(id, TemplatePoleMission);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}
		return new ResponseEntity<>("Sửa thông tin template thành công", HttpStatus.OK);
	}

	/**
	 * Restful API Creates the.
	 *
	 * @param TemplatePoleMission the template pole mission
	 * @param code the code
	 * @return true, if successful
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean create(@Valid @RequestBody TemplatePoleMission TemplatePoleMission, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		
		if(check) {
			controller.createTempPoleMiss(TemplatePoleMission);
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
		
		if(role_links != null) {
			check = true;
		}
		
		if(check) {
			controller.deleteTempPoleMiss(id);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}		
		
		return new ResponseEntity<>("Xóa thông tin template thành công", HttpStatus.OK);
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
		TemplatePoleMission pm = new TemplatePoleMission();
		pm.setName("Mẫu 1");
		pm.setDes("Mẫu cột 500KV");
		pm.setPoletype("Cột 500KV");
		pm.setPoint(lp);

		controller.createTempPoleMiss(pm);

		return true;
	}
}
