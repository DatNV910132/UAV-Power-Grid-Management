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
 * The Class Report.
 */
@Document(collection = "Report")
public class Report {

	/** The id. */
	@Id
	public ObjectId _id;
	
	/** The Report name. */
	private String Report_Name;
	
	/** The Report des. */
	private String Report_Des;
	
	/** The Report type. */
	private String Report_Type;
	
	/** The Report date create. */
	private Date Report_DateCreate;
	
	/** The Report date update. */
	private Date Report_DateUpdate;
	
	/** The Report emp ID. */
	private String Report_EmpID;
	
	/** The Report link. */
	private String Report_link;
	
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
	 * Gets the report name.
	 *
	 * @return the report name
	 */
	public String getReport_Name() {
		return Report_Name;
	}

	/**
	 * Sets the report name.
	 *
	 * @param report_Name the new report name
	 */
	public void setReport_Name(String report_Name) {
		Report_Name = report_Name;
	}

	/**
	 * Gets the report des.
	 *
	 * @return the report des
	 */
	public String getReport_Des() {
		return Report_Des;
	}

	/**
	 * Sets the report des.
	 *
	 * @param report_Des the new report des
	 */
	public void setReport_Des(String report_Des) {
		Report_Des = report_Des;
	}

	/**
	 * Gets the report type.
	 *
	 * @return the report type
	 */
	public String getReport_Type() {
		return Report_Type;
	}

	/**
	 * Sets the report type.
	 *
	 * @param report_Type the new report type
	 */
	public void setReport_Type(String report_Type) {
		Report_Type = report_Type;
	}

	/**
	 * Gets the report date create.
	 *
	 * @return the report date create
	 */
	public Date getReport_DateCreate() {
		return Report_DateCreate;
	}

	/**
	 * Sets the report date create.
	 *
	 * @param report_DateCreate the new report date create
	 */
	public void setReport_DateCreate(Date report_DateCreate) {
		Report_DateCreate = report_DateCreate;
	}

	/**
	 * Gets the report date update.
	 *
	 * @return the report date update
	 */
	public Date getReport_DateUpdate() {
		return Report_DateUpdate;
	}

	/**
	 * Sets the report date update.
	 *
	 * @param report_DateUpdate the new report date update
	 */
	public void setReport_DateUpdate(Date report_DateUpdate) {
		Report_DateUpdate = report_DateUpdate;
	}

	/**
	 * Gets the report emp ID.
	 *
	 * @return the report emp ID
	 */
	public String getReport_EmpID() {
		return Report_EmpID;
	}

	/**
	 * Sets the report emp ID.
	 *
	 * @param report_EmpID the new report emp ID
	 */
	public void setReport_EmpID(String report_EmpID) {
		Report_EmpID = report_EmpID;
	}

	/**
	 * Gets the report link.
	 *
	 * @return the report link
	 */
	public String getReport_link() {
		return Report_link;
	}

	/**
	 * Sets the report link.
	 *
	 * @param report_link the new report link
	 */
	public void setReport_link(String report_link) {
		Report_link = report_link;
	}

}
