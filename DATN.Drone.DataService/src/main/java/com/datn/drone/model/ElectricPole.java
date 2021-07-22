/*
 * 
 */
package com.datn.drone.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class ElectricPole.
 */
@Document(collection = "ElecPole")
public class ElectricPole {
	
	/** The id. */
	@Id
	public ObjectId _id;
	
	/** The Pole name. */
	private String Pole_Name;
	
	/** The Pole type. */
	private String Pole_Type;
	
	/** The Pole latitude. */
	private Double Pole_Latitude;
	
	/** The Pole longitude. */
	private Double Pole_Longitude;
	
	/** The Description. */
	private String Description;
	
	/** The Build time. */
	private Date BuildTime;
	
	/** The E P maintenance time. */
	private Date EP_MaintenanceTime;

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
	 * Gets the pole name.
	 *
	 * @return the pole name
	 */
	public String getPole_Name() {
		return Pole_Name;
	}

	/**
	 * Sets the pole name.
	 *
	 * @param pole_Name the new pole name
	 */
	public void setPole_Name(String pole_Name) {
		Pole_Name = pole_Name;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * Gets the pole latitude.
	 *
	 * @return the pole latitude
	 */
	public Double getPole_Latitude() {
		return Pole_Latitude;
	}

	/**
	 * Sets the pole latitude.
	 *
	 * @param pole_Latitude the new pole latitude
	 */
	public void setPole_Latitude(Double pole_Latitude) {
		Pole_Latitude = pole_Latitude;
	}

	/**
	 * Gets the pole longitude.
	 *
	 * @return the pole longitude
	 */
	public Double getPole_Longitude() {
		return Pole_Longitude;
	}

	/**
	 * Sets the pole longitude.
	 *
	 * @param pole_Longitude the new pole longitude
	 */
	public void setPole_Longitude(Double pole_Longitude) {
		Pole_Longitude = pole_Longitude;
	}

	/**
	 * Gets the builds the time.
	 *
	 * @return the builds the time
	 */
	public Date getBuildTime() {
		return BuildTime;
	}

	/**
	 * Sets the builds the time.
	 *
	 * @param buildTime the new builds the time
	 */
	public void setBuildTime(Date buildTime) {
		BuildTime = buildTime;
	}

	/**
	 * Gets the e P maintenance time.
	 *
	 * @return the e P maintenance time
	 */
	public Date getEP_MaintenanceTime() {
		return EP_MaintenanceTime;
	}

	/**
	 * Sets the e P maintenance time.
	 *
	 * @param eP_MaintenanceTime the new e P maintenance time
	 */
	public void setEP_MaintenanceTime(Date eP_MaintenanceTime) {
		EP_MaintenanceTime = eP_MaintenanceTime;
	}

	/**
	 * Gets the pole type.
	 *
	 * @return the pole type
	 */
	public String getPole_Type() {
		return Pole_Type;
	}

	/**
	 * Sets the pole type.
	 *
	 * @param pole_Type the new pole type
	 */
	public void setPole_Type(String pole_Type) {
		Pole_Type = pole_Type;
	}
	
}
