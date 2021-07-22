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
import com.datn.drone.controller.RoleController;
import com.datn.drone.controller.Role_LinkController;
import com.datn.drone.exception.NotFoundException;
import com.datn.drone.model.Role;
import com.datn.drone.model.Role_Link;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleServer.
 */
@RestController
@RequestMapping("/roles")
public class RoleServer {
	
	/** The rolecontroller. */
	@Autowired
	private RoleController rolecontroller;
	
	/** The role linkcontroller. */
	@Autowired
	private Role_LinkController role_linkcontroller;

	/**
	 * Restful API Gets the all roles.
	 *
	 * @return the all roles
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	private List<Role> getAllRoles() {
		List<Role> roles = rolecontroller.getAllRoles();

		if (roles == null) {
			throw new NotFoundException();
		}
		return roles;
	}
	
	/**
	 * Restful API Gets the by id.
	 *
	 * @param id the id
	 * @return the Role by id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private Role getById(@PathVariable("id") ObjectId id) {
		Role role = rolecontroller.getRoleById(id);

		if (role == null) {
			throw new NotFoundException();
		}
		return role;
	}
	
	/**
	 * Restful API Gets the by name.
	 *
	 * @param rolename the rolename
	 * @return the Role by name
	 */
	@RequestMapping(value = "/rolename/", method = RequestMethod.GET)
	private Role getByName(@RequestParam("rolename") String rolename) {
		Role role = rolecontroller.getbyRoleName(rolename);

		if (role == null) {
			throw new NotFoundException();
		}
		return role;
	}
	

	/**
	 * Restful API Modify role by id.
	 *
	 * @param id the id
	 * @param role the role
	 * @param code the code
	 * @return the response entity
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	private ResponseEntity<String> modifyRoleById(@PathVariable("id") ObjectId id,
			@Valid @RequestBody Role role, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		
		if(check) {
			rolecontroller.modifyRoleById(id, role);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}		
		
		return new ResponseEntity<>("Sửa thông tin Quyền thành công", HttpStatus.OK);
	}

	/**
	 * Restful API Creates the role.
	 *
	 * @param role the role
	 * @param code the code
	 * @return the role
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	private Role createRole(@Valid @RequestBody Role role, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		
		if(check) {
			return rolecontroller.createRole(role);
		} else {
			throw new NotFoundException("Permission Denied");
		}
	
	}

	/**
	 * Restful API Delete role.
	 *
	 * @param id the id
	 * @param code the code
	 * @return the response entity
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	private ResponseEntity<String> deleteRole(@PathVariable ObjectId id, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		
		if(check) {
			rolecontroller.deleteRole(id);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}
		
		return new ResponseEntity<>("Xóa Quyền thành công", HttpStatus.OK);
	}
	
}
