/*
 * 
 */
package com.datn.drone.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.datn.drone.model.Video;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;

// TODO: Auto-generated Javadoc
/**
 * The Class VideoController.
 */
@Service
public class VideoController {

    
    /** The grid fs template. */
    @Autowired
    private GridFsTemplate gridFsTemplate;

    /** The operations. */
    @Autowired
    private GridFsOperations operations;

    /**
     * Gets the video.
     *
     * @param id the id
     * @return the video
     * @throws IllegalStateException the illegal state exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public Video getVideo(String id) throws IllegalStateException, IOException {
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
        Video video = new Video();
        video.setTitle(file.getMetadata().get("title").toString());
        video.setStream(operations.getResource(file).getInputStream());
        return video;
    }
    
    /**
     * Gets the all video.
     *
     * @return the all video
     * @throws IllegalStateException the illegal state exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public List<String> getAllVideo() throws IllegalStateException, IOException {
        GridFSFindIterable files = gridFsTemplate.find(new Query(Criteria.where("filename").is("file")));
        List<String> result = new ArrayList<>();
        for(GridFSFile file: files) {
        	result.add(file.getObjectId().toString());
        }
        return result;
    }
    
    /**
     * Delete.
     *
     * @param id the id
     * @throws IllegalStateException the illegal state exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void delete(String id) throws IllegalStateException, IOException {
        gridFsTemplate.delete(new Query(Criteria.where("_id").is(id)));
    }
   

    /**
     * Adds the video.
     *
     * @param title the title
     * @param dateCreate the date create
     * @param dateImport the date import
     * @param des the des
     * @param idpole the idpole
     * @param iduser the iduser
     * @param iddrone the iddrone
     * @param file the file
     * @return the string
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public String addVideo(String title,String dateCreate, String dateImport,
    		String des,String idpole,String iduser,String iddrone, MultipartFile file) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("type", "video");
        metaData.put("title", title);
        metaData.put("dateCreate", dateCreate);
        metaData.put("dateImport", dateImport);
        metaData.put("description", des);
        metaData.put("idpole", idpole);
        metaData.put("iduser", iduser);
        metaData.put("iddrone", iddrone);
        ObjectId id = gridFsTemplate.store(file.getInputStream(), file.getName(), file.getContentType(), metaData);
        return id.toString();
    }
}
