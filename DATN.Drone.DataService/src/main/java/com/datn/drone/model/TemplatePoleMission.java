/*
 * 
 */
package com.datn.drone.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class TemplatePoleMission.
 */
@Document(collection = "TemplatePoleMission")
public class TemplatePoleMission {

	/** The id. */
	@Id
	public ObjectId _id;
	
	/** The name. */
	public String name;
	
	/** The des. */
	public String des;
	
	/** The poletype. */
	public String poletype;
	
	/** The point. */
	public List<Point> point = new ArrayList<>();
	
	/** The createat. */
	public LocalDateTime createat;
	
	/** The updateat. */
	public LocalDateTime updateat;

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
	 * Gets the poletype.
	 *
	 * @return the poletype
	 */
	public String getPoletype() {
		return poletype;
	}

	/**
	 * Sets the poletype.
	 *
	 * @param poletype the new poletype
	 */
	public void setPoletype(String poletype) {
		this.poletype = poletype;
	}

	/**
	 * Gets the point.
	 *
	 * @return the point
	 */
	public List<Point> getPoint() {
		return point;
	}

	/**
	 * Sets the point.
	 *
	 * @param point the new point
	 */
	public void setPoint(List<Point> point) {
		this.point = point;
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

}
