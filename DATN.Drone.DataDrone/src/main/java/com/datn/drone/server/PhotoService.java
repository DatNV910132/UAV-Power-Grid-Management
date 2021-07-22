/*
 * 
 */
package com.datn.drone.server;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.datn.drone.controller.PhotoController;
import com.datn.drone.model.Photo;

// TODO: Auto-generated Javadoc
/**
 * The Class PhotoService.
 */
@RestController
@RequestMapping("/photos")
public class PhotoService {

	/** The photo service. */
	@Autowired
	private PhotoController photoService;

	/**
	 * Gets the photo.
	 *
	 * @param id the id
	 * @return the photo
	 */
	@GetMapping("/{id}")
	public Photo getPhoto(@PathVariable String id) {
		Photo photo = photoService.getPhoto(id);
		return photo;
	}
	
	/**
	 * Gets the photo binary.
	 *
	 * @param id the id
	 * @return the photo binary
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@GetMapping(
			  value = "/byte/{id}",
			  produces = MediaType.IMAGE_JPEG_VALUE
			)
	public @ResponseBody byte[] getPhotoBinary(@PathVariable String id) throws IOException {
		Photo photo = photoService.getPhoto(id);
		return photo.getImage().getData();
	}
	
	/**
	 * Compare.
	 *
	 * @param idimage1 the idimage 1
	 * @param idimage2 the idimage 2
	 * @return the double
	 */
	@GetMapping("/imagecompare")
	public double compare(@RequestParam("idimage1") String idimage1, @RequestParam("idimage2") String idimage2) {
		double photo = 0;
		try {
			photo = photoService.CompareImage(idimage1, idimage2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return photo;
	}
	
	/**
	 * Crop photo.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the photo
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@GetMapping("/crop/{id}")
	public Photo cropPhoto(@PathVariable String id, Model model) throws IOException {
		Photo photo = photoService.CropImage(id);
		return photo;
	}

	/**
	 * Gets the listcheck.
	 *
	 * @param idpole the idpole
	 * @param date the date
	 * @param crop the crop
	 * @return the listcheck
	 */
	@GetMapping("/listimagecheck")
	public List<String> getlistcheck(@RequestParam("idpole") String idpole, @RequestParam("date") String date,@RequestParam("crop") boolean crop) {
		List<String> photo = photoService.getimagecheckinci(idpole, date, crop);
		return photo;
	}
	
	/**
	 * Gets the all ID photo.
	 *
	 * @return the all ID photo
	 */
	@GetMapping("/allid")
	public List<String> getAllIDPhoto() {
		List<Photo> photo = photoService.getAllPhoto();
		List<String> lsid = new ArrayList<>();
		int sum = photo.size();
		for(int i = 0; i < sum; i++) {
			lsid.add(photo.get(i).get_id());
		}
		return lsid;
	}
	
	/**
	 * Count.
	 *
	 * @return the int
	 */
	@GetMapping("/countall")
	public int count() {
		List<Photo> photo = photoService.getAllPhoto();
		return photo.size();
	}
	
	/**
	 * Gets the all photo.
	 *
	 * @return the all photo
	 */
	@GetMapping("/all")
	public List<Photo> getAllPhoto() {
		List<Photo> photo = photoService.getAllPhoto();
		
		
		
		return photo;
	}
	
	/**
	 * Autoinci.
	 *
	 * @return the list
	 * @throws ParseException the parse exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@GetMapping("/autoinci")
	public List<String> autoinci() throws ParseException, IOException {
		return photoService.autocheckinci();
	}
	
	
	/**
	 * Gets the emp byrole.
	 *
	 * @param date_standard the date standard
	 * @return the emp byrole
	 */
	@RequestMapping(value = "/setautostandard", method = RequestMethod.GET)
	public String getEmpByrole(@RequestParam String date_standard) {
		return photoService.setStandard(date_standard);
		
	}
	
	/**
	 * Gets the emp byrole.
	 *
	 * @return the emp byrole
	 */
	@RequestMapping(value = "/autostandard", method = RequestMethod.GET)
	public String getEmpByrole() {
		return photoService.date_autocheckinci_standard;
		
	}
	
	/**
	 * Adds the photo.
	 *
	 * @param title the title
	 * @param type the type
	 * @param dateCreate the date create
	 * @param dateImport the date import
	 * @param des the des
	 * @param idpole the idpole
	 * @param iduser the iduser
	 * @param iddrone the iddrone
	 * @param crop the crop
	 * @param image the image
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@PostMapping("/add")
	public String addPhoto(@RequestParam("title") String title,@RequestParam("type") String type, @RequestParam("dateCreate") String dateCreate,
			@RequestParam("dateImport") String dateImport, @RequestParam("des") String des,
			@RequestParam("idpole") String idpole, @RequestParam("iduser") String iduser, @RequestParam("iddrone") String iddrone,@RequestParam("crop") boolean crop, @RequestPart("image") MultipartFile image)
			throws IOException {
		String id = photoService.addPhoto(title,type, dateCreate, dateImport, des, idpole, iduser, iddrone, crop, image);
		return id;
	}

	/**
	 * Delete photo.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePhoto(@PathVariable String id) {
		photoService.deletePhoto(id);
		return new ResponseEntity<>("Photo delete successsfully", HttpStatus.OK);
	}
	
	/**
	 * Update user photo.
	 *
	 * @param img the img
	 * @return the string
	 */
	@PostMapping(value = "/updatePhoto" )
	public String updateUserPhoto(@RequestPart(name = "img") MultipartFile img) {
	    {
	        System.out.println("Request  update photo "+ img.getOriginalFilename());
	        return "OK";
	    }
	}

}
