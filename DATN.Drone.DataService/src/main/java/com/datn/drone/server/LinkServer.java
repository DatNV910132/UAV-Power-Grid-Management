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

import com.datn.drone.controller.LinkController;
import com.datn.drone.controller.Role_LinkController;
import com.datn.drone.exception.NotFoundException;
import com.datn.drone.model.Link;
import com.datn.drone.model.Role_Link;

// TODO: Auto-generated Javadoc
/**
 * The Class LinkServer.
 */
@RestController
@RequestMapping("/links")
public class LinkServer {

	/** The Linkcontroller. */
	@Autowired
	private LinkController Linkcontroller;
	
	/** The role linkcontroller. */
	@Autowired
	private Role_LinkController role_linkcontroller;

	/**
	 * Restful API Gets the all links.
	 *
	 * @return the all links
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	private List<Link> getAllLinks() {
		List<Link> Links = Linkcontroller.getAllLinks();

		if (Links == null) {
			throw new NotFoundException();
		}
		return Links;
	}
	
	/**
	 * Restful API Gets the by id.
	 *
	 * @param id the id
	 * @return the link by id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private Link getById(@PathVariable("id") ObjectId id) {
		Link Link = Linkcontroller.getLinkById(id);

		if (Link == null) {
			throw new NotFoundException();
		}
		return Link;
	}
	
	/**
	 * Restful API Gets the by url.
	 *
	 * @param url the url
	 * @return the link by url
	 */
	@RequestMapping(value = "/url/", method = RequestMethod.GET)
	private Link getByUrl(@RequestParam("url") String url) {
		Link Link = Linkcontroller.getbyurl(url);

		if (Link == null) {
			throw new NotFoundException();
		}
		return Link;
	}
	

	/**
	 * Restful API Modify link by id.
	 *
	 * @param id the id
	 * @param Link the link
	 * @param code the code
	 * @return the response entity
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	private ResponseEntity<String> modifyLinkById(@PathVariable("id") ObjectId id,
			@Valid @RequestBody Link Link, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		
		if(check) {
			Linkcontroller.modifyLinkById(id, Link);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}	
		
		return new ResponseEntity<>("Sửa thông tin Link thành công", HttpStatus.OK);
	}

	/**
	 * Restful API Creates the link.
	 *
	 * @param Link the link
	 * @param code the code
	 * @return the link
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	private Link createLink(@Valid @RequestBody Link Link, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		
		if(check) {
			return Linkcontroller.createLink(Link);
		} else {
			throw new NotFoundException("Permission Denied");
		}
		
	}

	/**
	 * Restful API Delete link.
	 *
	 * @param id the id
	 * @param code the code
	 * @return the response entity
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	private ResponseEntity<String> deleteLink(@PathVariable ObjectId id, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		
		if(check) {
			Linkcontroller.deleteLink(id);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}
		return new ResponseEntity<>("Xóa Link thành công", HttpStatus.OK);
	}
}
