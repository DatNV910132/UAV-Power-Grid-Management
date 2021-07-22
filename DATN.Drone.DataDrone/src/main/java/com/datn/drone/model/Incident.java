/*
 * 
 */
package com.datn.drone.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Incident.
 */
public class Incident {

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
	
	/** The iddetect. */
	public String iddetect;
	
	/** The idpole. */
	public String idpole;
	
	/** The image. */
	public String image;
	
	

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

	/**
	 * Instantiates a new incident.
	 *
	 * @param name the name
	 * @param des the des
	 * @param date the date
	 * @param status the status
	 * @param level the level
	 * @param iddetect the iddetect
	 * @param idpole the idpole
	 * @param image the image
	 */
	public Incident(String name, String des, String date, String status, String level, String iddetect, String idpole,
			String image) {
		super();
		this.name = name;
		this.des = des;
		this.date = date;
		this.status = status;
		this.level = level;
		this.iddetect = iddetect;
		this.idpole = idpole;
		this.image = image;
	}
	
}

