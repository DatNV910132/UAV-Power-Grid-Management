/*
 * 
 */
package com.datn.drone.model;

import java.time.LocalDateTime;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class Role_Link.
 */
@Document(collection = "Role_Link")
public class Role_Link {
	
	/** The id. */
	@Id
	private ObjectId _id;
	
	/** The idlink. */
	private String idlink;
	
	/** The idresource. */
	private String idresource;
	
	/** The code. */
	private String code;
	
	/** The createat. */
	private LocalDateTime createat;
	
	/** The updateat. */
	private LocalDateTime updateat;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String get_id() {
		return _id.toHexString();
	}

	/**
	 * Sets the id.
	 *
	 * @param _id the new id
	 */
	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	/**
	 * Gets the idlink.
	 *
	 * @return the idlink
	 */
	public String getIdlink() {
		return idlink;
	}

	/**
	 * Sets the idlink.
	 *
	 * @param idlink the new idlink
	 */
	public void setIdlink(String idlink) {
		this.idlink = idlink;
	}

	/**
	 * Gets the idresource.
	 *
	 * @return the idresource
	 */
	public String getIdresource() {
		return idresource;
	}

	/**
	 * Sets the idresource.
	 *
	 * @param idresource the new idresource
	 */
	public void setIdresource(String idresource) {
		this.idresource = idresource;
	}


	/**
	 * Gets the createat.
	 *
	 * @return the createat
	 */
	public LocalDateTime getCreateat() {
		return createat;
	}

	/**
	 * Sets the createat.
	 *
	 * @param createat the new createat
	 */
	public void setCreateat(LocalDateTime createat) {
		this.createat = createat;
	}

	/**
	 * Gets the updateat.
	 *
	 * @return the updateat
	 */
	public LocalDateTime getUpdateat() {
		return updateat;
	}

	/**
	 * Sets the updateat.
	 *
	 * @param updateat the new updateat
	 */
	public void setUpdateat(LocalDateTime updateat) {
		this.updateat = updateat;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * Instantiates a new role link.
	 */
	public Role_Link() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Role_Link [_id=" + _id + ", idlink=" + idlink + ", idresource=" + idresource + ", code=" + code
				+ ", createat=" + createat + ", updateat=" + updateat + "]";
	}


	

}
