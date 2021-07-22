/*
 * 
 */
package com.datn.drone.model;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: Auto-generated Javadoc
/**
 * The Class Photo.
 */
@Document(collection = "Photos")
public class Photo {

	/** The id. */
	@Id
	public ObjectId _id;

	/** The title. */
	private String title;
	
	/** The type. */
	private String type;
	
	/** The date create. */
	private String dateCreate;
	
	/** The date import. */
	private String dateImport;
	
	/** The description. */
	private String description;
	
	/** The idpole. */
	private String idpole;
	
	/** The iduser. */
	private String iduser;
	
	/** The iddrone. */
	private String iddrone;
	
	/** The crop. */
	private boolean crop;
	
	/** The image. */
	private Binary image;

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
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public Binary getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(Binary image) {
		this.image = image;
	}

	/**
	 * Gets the date create.
	 *
	 * @return the date create
	 */
	public String getDateCreate() {
		return dateCreate;
	}

	/**
	 * Sets the date create.
	 *
	 * @param dateCreate the new date create
	 */
	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}

	/**
	 * Gets the date import.
	 *
	 * @return the date import
	 */
	public String getDateImport() {
		return dateImport;
	}

	/**
	 * Sets the date import.
	 *
	 * @param dateImport the new date import
	 */
	public void setDateImport(String dateImport) {
		this.dateImport = dateImport;
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
	 * Checks if is crop.
	 *
	 * @return true, if is crop
	 */
	public boolean isCrop() {
		return crop;
	}
	
	/**
	 * Sets the crop.
	 *
	 * @param crop the new crop
	 */
	public void setCrop(boolean crop) {
		this.crop = crop;
	}

	/**
	 * Gets the iduser.
	 *
	 * @return the iduser
	 */
	public String getIduser() {
		return iduser;
	}

	/**
	 * Sets the iduser.
	 *
	 * @param iduser the new iduser
	 */
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	/**
	 * Gets the iddrone.
	 *
	 * @return the iddrone
	 */
	public String getIddrone() {
		return iddrone;
	}

	/**
	 * Sets the iddrone.
	 *
	 * @param iddrone the new iddrone
	 */
	public void setIddrone(String iddrone) {
		this.iddrone = iddrone;
	}

	

	/**
	 * Instantiates a new photo.
	 *
	 * @param title the title
	 * @param type the type
	 * @param dateCreate the date create
	 * @param dateImport the date import
	 * @param description the description
	 * @param idpole the idpole
	 * @param iduser the iduser
	 * @param iddrone the iddrone
	 * @param crop the crop
	 */
	public Photo(String title, String type, String dateCreate, String dateImport, String description, String idpole,
			String iduser, String iddrone, boolean crop) {
		super();
		this.title = title;
		this.type = type;
		this.dateCreate = dateCreate;
		this.dateImport = dateImport;
		this.description = description;
		this.idpole = idpole;
		this.iduser = iduser;
		this.iddrone = iddrone;
		this.crop = crop;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Photo [_id=" + _id + ", title=" + title + ", type=" + type + ", dateCreate=" + dateCreate
				+ ", dateImport=" + dateImport + ", description=" + description + ", idpole=" + idpole + ", iduser="
				+ iduser + ", iddrone=" + iddrone + ", crop=" + crop + ", image=" + image + "]";
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Instantiates a new photo.
	 */
	public Photo() {
		// TODO Auto-generated constructor stub
	}

	
}
