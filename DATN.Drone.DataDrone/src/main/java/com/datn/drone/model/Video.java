/*
 * 
 */
package com.datn.drone.model;

import java.io.InputStream;


// TODO: Auto-generated Javadoc
/**
 * The Class Video.
 */
public class Video {
	
    /** The title. */
    private String title;
    
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
    
    /** The stream. */
    private InputStream stream;
    
    /**
     * Instantiates a new video.
     */
    public Video() {
        super();
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
     * Gets the stream.
     *
     * @return the stream
     */
    public InputStream getStream() {
        return stream;
    }

    /**
     * Sets the stream.
     *
     * @param stream the new stream
     */
    public void setStream(InputStream stream) {
        this.stream = stream;
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


}
