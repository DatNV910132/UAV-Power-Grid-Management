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
 * The Class Notification.
 */
@Document(collection = "Notification")
public class Notification {

	/** The id. */
	@Id
	public ObjectId _id;
	
	/** The userid. */
	public String userid;
	
	/** The title. */
	public String title;
	
	/** The content. */
	public String content;
	
	/** The link. */
	public String link;
	
	/** The sendto. */
	public String sendto;
	
	/** The status. */
	public String status;
	
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
	 * Gets the userid.
	 *
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * Sets the userid.
	 *
	 * @param userid the new userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
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
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the link.
	 *
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Sets the link.
	 *
	 * @param link the new link
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * Gets the sendto.
	 *
	 * @return the sendto
	 */
	public String getSendto() {
		return sendto;
	}

	/**
	 * Sets the sendto.
	 *
	 * @param sendto the new sendto
	 */
	public void setSendto(String sendto) {
		this.sendto = sendto;
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
