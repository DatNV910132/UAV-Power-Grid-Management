/*
 * 
 */
package com.datn.drone.server;

import java.security.NoSuchAlgorithmException;
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
import com.datn.drone.exception.NotFoundException;
import com.datn.drone.model.Role_Link;

// TODO: Auto-generated Javadoc
/**
 * The Class Role_LinkServer.
 */
@RestController
@RequestMapping("/rolelinks")
public class Role_LinkServer {

	/** The role linkcontroller. */
	@Autowired
	private Role_LinkController role_linkcontroller;
	

	/**
	 * Restful API Gets the all role links.
	 *
	 * @return the all role links
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	private List<Role_Link> getAllRole_Links() {
		List<Role_Link> Role_Links = role_linkcontroller.getAllRole_Links();

		if (Role_Links == null) {
			throw new NotFoundException();
		}
		return Role_Links;
	}
	
	/**
	 * Restful API Gets the by id.
	 *
	 * @param id the id
	 * @return the Role_Link by id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private Role_Link getById(@PathVariable("id") ObjectId id) {
		Role_Link Role_Link = role_linkcontroller.getRole_LinkById(id);

		if (Role_Link == null) {
			throw new NotFoundException();
		}
		return Role_Link;
	}
	
	/**
	 * Restful API Gets the byidurl.
	 *
	 * @param idurl the idurl
	 * @return the Role_Link byidurl
	 */
	@RequestMapping(value = "/url/", method = RequestMethod.GET)
	private Role_Link getByidurl(@RequestParam("idurl") String idurl) {
		Role_Link Role_Links = role_linkcontroller.getRole_Linksbyidurl(idurl);

		if (Role_Links == null) {
			throw new NotFoundException();
		}
		return Role_Links;
	}
	
	/**
	 * Restful API Gets the byidresource.
	 *
	 * @param idresource the idresource
	 * @return the Role_Link byidresource
	 */
	@RequestMapping(value = "/resource/", method = RequestMethod.GET)
	private List<Role_Link> getByidresource(@RequestParam("idresource") String idresource) {
		List<Role_Link> Role_Links = role_linkcontroller.getRole_Linksbyresource(idresource);

		if (Role_Links == null) {
			throw new NotFoundException();
		}
		return Role_Links;
	}
	
	/**
	 * Restful API Gets the bycode.
	 *
	 * @param code the code
	 * @return the Role_Link by code
	 */
	@RequestMapping(value = "/code/", method = RequestMethod.GET)
	private Role_Link getBycode(@RequestParam("code") String code) {
		Role_Link Role_Link = role_linkcontroller.getbycode(code);

		if (Role_Link == null) {
			throw new NotFoundException();
		}
		return Role_Link;
	}
	
	

	/**
	 * Restful API Modify role link by id.
	 *
	 * @param id the id
	 * @param Role_Link the role link
	 * @param code the code
	 * @return the response entity
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	private ResponseEntity<String> modifyRole_LinkById(@PathVariable("id") ObjectId id,
			@Valid @RequestBody Role_Link Role_Link, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		
		if(check) {
			role_linkcontroller.modifyRole_LinkById(id, Role_Link);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}			
		return new ResponseEntity<>("Sửa thông tin liên kết Quyền và Url  thành công", HttpStatus.OK);
	}

	/**
	 * Restful API Creates the role link.
	 *
	 * @param Role_Link the role link
	 * @param code the code
	 * @return the role link
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	private Role_Link createRole_Link(@Valid @RequestBody Role_Link Role_Link, @RequestParam("code") String code) throws NoSuchAlgorithmException {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		
		if(check) {
			return role_linkcontroller.createRole_Link(Role_Link);
		} else {
			throw new NotFoundException("Permission Denied");
		}
		
	}

//	@RequestMapping(value = "/addall", method = RequestMethod.POST)
//	private ResponseEntity<String> addall(@RequestParam("idrole") String idrole) throws NoSuchAlgorithmException {
//		role_linkcontroller.addall(idrole);
//		return new ResponseEntity<>("Thêm thành công", HttpStatus.OK);
//	}
/**
 * Restful API Delete role link.
 *
 * @param id the id
 * @param code the code
 * @return the response entity
 */
//	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	private ResponseEntity<String> deleteRole_Link(@PathVariable ObjectId id, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		
		if(check) {
			role_linkcontroller.deleteRole_Link(id);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}
			
		return new ResponseEntity<>("Xóa liên kết Quyền và Url thành công", HttpStatus.OK);
	}
}
