/*
 * 
 */
package com.datn.drone.server;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.datn.drone.controller.VideoController;
import com.datn.drone.model.Video;

// TODO: Auto-generated Javadoc
/**
 * The Class VideoService.
 */
@RestController
@RequestMapping("/videos")
public class VideoService{

	 /** The video service. */
 	@Autowired
	    private VideoController videoService;

	    /**
    	 * Gets the video.
    	 *
    	 * @param id the id
    	 * @return the video
    	 * @throws IllegalStateException the illegal state exception
    	 * @throws IOException Signals that an I/O exception has occurred.
    	 */
    	@GetMapping("/{id}")
	    public String getVideo(@PathVariable String id) throws IllegalStateException, IOException {
	        Video video = videoService.getVideo(id);
	        return video.getTitle();
	    }
	    
    	/**
    	 * Gets the all.
    	 *
    	 * @return the all
    	 * @throws IllegalStateException the illegal state exception
    	 * @throws IOException Signals that an I/O exception has occurred.
    	 */
    	@GetMapping("/allid")
	    public List<String> getall() throws IllegalStateException, IOException {
	        return videoService.getAllVideo();
	    }
	    
	    /**
    	 * Count.
    	 *
    	 * @return the int
    	 * @throws IllegalStateException the illegal state exception
    	 * @throws IOException Signals that an I/O exception has occurred.
    	 */
    	@GetMapping("/countall")
	    public int count() throws IllegalStateException, IOException {
	        return videoService.getAllVideo().size();
	    }


	    /**
    	 * Stream video.
    	 *
    	 * @param id the id
    	 * @param response the response
    	 * @throws IllegalStateException the illegal state exception
    	 * @throws IOException Signals that an I/O exception has occurred.
    	 */
    	@GetMapping("/stream/{id}")
	    public void streamVideo(@PathVariable String id, HttpServletResponse response) throws IllegalStateException, IOException {
	        Video video = videoService.getVideo(id);
	        FileCopyUtils.copy(video.getStream(), response.getOutputStream());
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
    	 * @param model the model
    	 * @return the string
    	 * @throws IOException Signals that an I/O exception has occurred.
    	 */
    	@PostMapping("/add")
	    public String addVideo(@RequestParam("title") String title, @RequestParam("dateCreate") String dateCreate,
				@RequestParam("dateImport") String dateImport, @RequestParam("des") String des,@RequestParam("idpole") String idpole,
				@RequestParam("iduser") String iduser,@RequestParam("iddrone") String iddrone, @RequestParam("file") MultipartFile file, Model model) throws IOException {
	        String id = videoService.addVideo(title, dateCreate, dateImport, des,idpole,iduser,iddrone, file);
	        return id;
	    }
	    
	    /**
    	 * Delete video.
    	 *
    	 * @param id the id
    	 * @throws IllegalStateException the illegal state exception
    	 * @throws IOException Signals that an I/O exception has occurred.
    	 */
    	@DeleteMapping("videos/{id}")
	    public void deleteVideo(@PathVariable String id) throws IllegalStateException, IOException {
	    	videoService.delete(id);
	    }
}
