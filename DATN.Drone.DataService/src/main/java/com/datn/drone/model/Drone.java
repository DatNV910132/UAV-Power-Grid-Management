/*
 * @author : Nguyen Van Dat 20154484
 * @version : 1.0
 * @copyright : Dat.NV154484 DATN
 */
package com.datn.drone.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class Drone.
 */
@Document(collection = "Drone")
public class Drone {
	
	/** The id. */
	@Id
	public ObjectId _id;
	
	/** The Tên. */
	private String name;
	
	/** The Mô tả. */
	private String des;
	
	/** The ID người quản lý. */
	private String idman;
	
	/** The tình trạng online. */
	private boolean online;
	
	/** The battery. */
	private int battery;
	
	/** The dateuse. */
	private Date dateuse;
	
	/** The status. */
	private String status;
	
	/** The maintenancetime. */
	private Date maintenancetime;

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
	 * Gets the idman.
	 *
	 * @return the idman
	 */
	public String getIdman() {
		return idman;
	}

	/**
	 * Sets the idman.
	 *
	 * @param idman the new idman
	 */
	public void setIdman(String idman) {
		this.idman = idman;
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
	 * Gets the maintenancetime.
	 *
	 * @return the maintenancetime
	 */
	public Date getMaintenancetime() {
		return maintenancetime;
	}

	/**
	 * Sets the maintenancetime.
	 *
	 * @param maintenancetime the new maintenancetime
	 */
	public void setMaintenancetime(Date maintenancetime) {
		this.maintenancetime = maintenancetime;
	}

	/**
	 * Checks if is online.
	 *
	 * @return true, if is online
	 */
	public boolean isOnline() {
		return online;
	}

	/**
	 * Sets the online.
	 *
	 * @param online the new online
	 */
	public void setOnline(boolean online) {
		this.online = online;
	}

	/**
	 * Gets the battery.
	 *
	 * @return the battery
	 */
	public int getBattery() {
		return battery;
	}

	/**
	 * Sets the battery.
	 *
	 * @param battery the new battery
	 */
	public void setBattery(int battery) {
		this.battery = battery;
	}

	/**
	 * Gets the dateuse.
	 *
	 * @return the dateuse
	 */
	public Date getDateuse() {
		return dateuse;
	}

	/**
	 * Sets the dateuse.
	 *
	 * @param dateuse the new dateuse
	 */
	public void setDateuse(Date dateuse) {
		this.dateuse = dateuse;
	}

	
}
