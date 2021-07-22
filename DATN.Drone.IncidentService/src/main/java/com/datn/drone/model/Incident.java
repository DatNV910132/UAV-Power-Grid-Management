/*
 * 
 */
package com.datn.drone.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class Incident.
 */
@Document(collection = "Incident")
public class Incident {
	
	/** The id. */
	@Id
	public ObjectId _id;
	
	/** The name. */
	public String name;
	
	/** The des. */
	public String des;
	
	/** The date. */
	public String date;
	
	/** The status. */
	public String status;
	
	/** The level. */
	public String level;
	
	/** The idfix. */
	public String idfix;
	
	/** The iddetect. */
	public String iddetect;
	
	/** The idpole. */
	public String idpole;
	
	/** The image. */
	public String image;
	
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the des.
	 *
	 * @return the des
	 */
	public String getDes() {
		return des;
	}

	/**
	 * Sets the des.
	 *
	 * @param des the new des
	 */
	public void setDes(String des) {
		this.des = des;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * Gets the idfix.
	 *
	 * @return the idfix
	 */
	public String getIdfix() {
		return idfix;
	}

	/**
	 * Sets the idfix.
	 *
	 * @param idfix the new idfix
	 */
	public void setIdfix(String idfix) {
		this.idfix = idfix;
	}

	/**
	 * Gets the idpole.
	 *
	 * @return the idpole
	 */
	public String getIdpole() {
		return idpole;
	}

	/**
	 * Sets the idpole.
	 *
	 * @param idpole the new idpole
	 */
	public void setIdpole(String idpole) {
		this.idpole = idpole;
	}

	/**
	 * Gets the iddetect.
	 *
	 * @return the iddetect
	 */
	public String getIddetect() {
		return iddetect;
	}

	/**
	 * Sets the iddetect.
	 *
	 * @param iddetect the new iddetect
	 */
	public void setIddetect(String iddetect) {
		this.iddetect = iddetect;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
}
