/*
 * 
 */
package com.datn.drone.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.drone.model.Role;
import com.datn.drone.repositories.RoleRepository;


// TODO: Auto-generated Javadoc
/**
 * The Class RoleController.
 */
@Service
public class RoleController {

	/** The repository. */
	@Autowired
	private RoleRepository repository;
	

	/**
	 * Lấy tất cả thông tin các Quyền.
	 *
	 * @return the all roles
	 */
	public List<Role> getAllRoles() {
		return repository.findAll();
	}

	/**
	 * Lấy thông tin của Quyền theo id đầu vào.
	 *
	 * @param id the id
	 * @return the role by id
	 */
	public Role getRoleById(ObjectId id) {
		return repository.findBy_id(id);
	}

	/**
	 * Lấy thông tin của Quyền thông qua tên của quyền.
	 *
	 * @param rolename the rolename
	 * @return the Role by role name
	 */
	public Role getbyRoleName(String rolename) {
		return repository.findByrolename(rolename);
	}
	
	/**
	 * Chỉnh sửa thông tin Quyền.
	 *
	 * @param id the id
	 * @param role the role
	 */
	public void modifyRoleById(ObjectId id,Role role) {
		LocalDateTime now = LocalDateTime.now();
		role.set_id(id);
		role.setUpdateat(now);
		repository.save(role);
	}

	/**
	 * Tạo Quyền mới.
	 *
	 * @param role the role
	 * @return the role
	 */
	public Role createRole(Role role) {
		LocalDateTime now = LocalDateTime.now();
		role.set_id(ObjectId.get());
		role.setCreateat(now);
		role.setUpdateat(now);
		repository.save(role);
		return role;
	}

	/**
	 * Xóa Quyền.
	 *
	 * @param id the id
	 */
	public void deleteRole(ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}
	
	
}
