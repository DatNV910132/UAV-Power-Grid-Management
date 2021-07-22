/*
 * 
 */
package com.datn.drone.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
@Document(collection = "Employee")
public class Employee {
	
	/** The id. */
	@Id
	public ObjectId _id;

	/** The username. */
	public String username;
	
	/** The password. */
	public String password;
	
	/** The idrole. */
	public String idrole;
	
	/** The name. */
	public String name;
	
	/** The birth. */
	public String birth;
	
	/** The sex. */
	public String sex;
	
	/** The nationality. */
	public String nationality;
	
	/** The address. */
	public String address;
	
	/** The mail. */
	public String mail;
	
	/** The phone. */
	public String phone;

	/**
	 * Instantiates a new employee.
	 */
	// Constructors
	public Employee() {
	}

/**
 * Gets the id.
 *
 * @return the id
 */
// ObjectId needs to be converted to string
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
	 * Gets the sex.
	 *
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * Sets the sex.
	 *
	 * @param sex the new sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}


	/**
	 * Gets the nationality.
	 *
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * Sets the nationality.
	 *
	 * @param nationality the new nationality
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the mail.
	 *
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Sets the mail.
	 *
	 * @param mail the new mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the idrole.
	 *
	 * @return the idrole
	 */
	public String getIdrole() {
		return idrole;
	}

	/**
	 * Sets the idrole.
	 *
	 * @param idrole the new idrole
	 */
	public void setIdrole(String idrole) {
		this.idrole = idrole;
	}

	/**
	 * Gets the birth.
	 *
	 * @return the birth
	 */
	public String getBirth() {
		return birth;
	}

	/**
	 * Sets the birth.
	 *
	 * @param birth the new birth
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Employee [_id=" + _id + ", username=" + username + ", password=" + password + ", idrole=" + idrole
				+ ", name=" + name + ", birth=" + birth + ", sex=" + sex + ", nationality=" + nationality + ", address="
				+ address + ", mail=" + mail + ", phone=" + phone + "]";
	}

	/**
	 * Instantiates a new employee.
	 *
	 * @param _id the id
	 * @param username the username
	 * @param password the password
	 * @param idrole the idrole
	 * @param name the name
	 * @param birth the birth
	 * @param sex the sex
	 * @param nationality the nationality
	 * @param address the address
	 * @param mail the mail
	 * @param phone the phone
	 */
	public Employee(ObjectId _id, String username, String password, String idrole, String name, String birth,
			String sex, String nationality, String address, String mail, String phone) {
		super();
		this._id = _id;
		this.username = username;
		this.password = password;
		this.idrole = idrole;
		this.name = name;
		this.birth = birth;
		this.sex = sex;
		this.nationality = nationality;
		this.address = address;
		this.mail = mail;
		this.phone = phone;
	}



}