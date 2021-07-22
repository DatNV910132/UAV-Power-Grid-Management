/*
 * 
 */
package com.datn.drone.controller;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.drone.exception.NotFoundException;
import com.datn.drone.model.Link;
import com.datn.drone.model.Role_Link;
import com.datn.drone.repositories.LinkRepository;
import com.datn.drone.repositories.Role_LinkRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class Role_LinkController.
 */
@Service
public class Role_LinkController {

	/** The repository. */
	@Autowired
	private Role_LinkRepository repository;
	
	/** The linkrepository. */
	@Autowired
	private LinkRepository linkrepository;
	
	/**
	 * Lấy tất cả thông tin các Url và Quyền.
	 *
	 * @return the all role links
	 */
	public List<Role_Link> getAllRole_Links() {
		return repository.findAll();
	}


	/**
	 * Lấy thông tin của Url và Quyền theo id đầu vào.
	 *
	 * @param id the id
	 * @return the role link by id
	 */
	public Role_Link getRole_LinkById(ObjectId id) {
		return repository.findBy_id(id);
	}

	/**
	 * Lấy danh sáng Url và Quyền thông qua một idurl.
	 *
	 * @param idurl the idurl
	 * @return the role linksbyidurl
	 */
	public Role_Link getRole_Linksbyidurl(String idurl){
		return repository.findByidlink(idurl);
	}
	
	/**
	 * Lấy danh sách Url và Quyền thông qua một id nguồn(id của role hoặc id của người dùng).
	 *
	 * @param idresource the idresource
	 * @return the role linksbyresource
	 */
	public List<Role_Link> getRole_Linksbyresource(String idresource){
		return repository.findByidresource(idresource);
	}
	

	/**
	 * Lấy URL và Quyền thông qua code(mã hóa SHA256).
	 *
	 * @param code the code
	 * @return the bycode
	 */
	public Role_Link getbycode(String code) {
		return repository.findBycode(code);
	}
	
	/**
	 * Chỉnh sửa thông tin Url và Quyền.
	 *
	 * @param id the id
	 * @param Role_Link the role link
	 */
	public void modifyRole_LinkById(ObjectId id,Role_Link Role_Link) {
		LocalDateTime now = LocalDateTime.now();
		Role_Link.set_id(id);
		Role_Link.setUpdateat(now);
		repository.save(Role_Link);
	}

	/**
	 * Tạo Url và Quyền mới.
	 *
	 * @param Role_Link the role link
	 * @return the role link
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 */
	public Role_Link createRole_Link(Role_Link Role_Link) throws NoSuchAlgorithmException {
		LocalDateTime now = LocalDateTime.now();
		Role_Link.set_id(ObjectId.get());
		Role_Link.setCreateat(now);
		Role_Link.setUpdateat(now);
		String primarycode = Role_Link.getIdlink()+"."+Role_Link.getIdresource();
		String code = SHA256.toHexString(SHA256.getSHA(primarycode));
		
		Role_Link check = repository.findBycode(code);
		if(check != null) {
			throw new NotFoundException("Quyền của người dùng đã tồn tại");
		} else {
			Role_Link.setCode(code);
			repository.save(Role_Link);
			return Role_Link;
		}
		
	}

	/**
	 * Xóa Url và Quyền.
	 *
	 * @param id the id
	 */
	public void deleteRole_Link(ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}
	
	/**
	 * Thêm tất cả liên kết giữa 1 Role và tất cả các đường link API.
	 *
	 * @param idrole the idrole
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 */
	public void addall(String idrole) throws NoSuchAlgorithmException {
		List<Link> links = linkrepository.findAll();
		
		for(Link l : links) {
			Role_Link role_link = new Role_Link();
			role_link.setIdlink(l.get_id());
			role_link.setIdresource(idrole);
			String primarycode = l.get_id()+"."+idrole;
			String code = SHA256.toHexString(SHA256.getSHA(primarycode));
			role_link.setCode(code);
			LocalDateTime ldt = LocalDateTime.now();
			role_link.setCreateat(ldt);
			role_link.setUpdateat(ldt);
			role_link.set_id(ObjectId.get());
			repository.save(role_link);
		}
		
	}
}
