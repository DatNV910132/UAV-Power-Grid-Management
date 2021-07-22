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
 * The Class Role.
 */
@Document(collection = "Roles")
public class Role {

	/** The id. */
	@Id
	private ObjectId _id;
	
	/** The rolename. */
	private String rolename;
	
	/** The description. */
	private String description;
	
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
	 * Gets the rolename.
	 *
	 * @return the rolename
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * Sets the rolename.
	 *
	 * @param rolename the new rolename
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Roles [_id=" + _id + ", rolename=" + rolename + ", description=" + description + ", createat="
				+ createat + ", updateat=" + updateat + "]";
	}
	
	
}
