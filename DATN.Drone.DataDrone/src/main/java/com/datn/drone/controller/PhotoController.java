/*
 * 
 */
package com.datn.drone.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.datn.drone.model.Incident;
import com.datn.drone.model.Photo;
import com.datn.drone.repository.PhotoRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PhotoController.
 */
@Service
public class PhotoController {

	/** The photo repo. */
	@Autowired
	private PhotoRepository photoRepo;

	/** The formatter. */
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	/** The listid autocheck. */
	private List<String> listid_autocheck = new ArrayList<>();
	
	/** The long today server. */
	long long_today_server = 1584378000000l;
	
	/** The date autocheckinci standard. */
	public String date_autocheckinci_standard = "17-03-2020";

	/**
	 * Gets the all photo.
	 *
	 * @return the all photo
	 */
	public List<Photo> getAllPhoto() {
		return photoRepo.findAll();
	}

	/**
	 * Gets the photo.
	 *
	 * @param id the id
	 * @return the photo
	 */
	public Photo getPhoto(String id) {
		return photoRepo.findById(id).get();
	}
	
	/**
	 * Sets the standard.
	 *
	 * @param date_standard the date standard
	 * @return the string
	 */
	public String setStandard(String date_standard) {
		date_autocheckinci_standard = date_standard;
		return date_autocheckinci_standard;
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
	 * @param file the file
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String addPhoto(String title,String type, String dateCreate, String dateImport, String des, String idpole, String iduser,
			String iddrone, boolean crop, MultipartFile file) throws IOException {
		Photo photo = new Photo(title, type, dateCreate, dateImport, des, idpole, iduser, iddrone, crop);
		photo.set_id(ObjectId.get());
		photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		photo = photoRepo.insert(photo);
		return photo.get_id();
	}

	/**
	 * Delete photo.
	 *
	 * @param id the id
	 */
	public void deletePhoto(String id) {
		photoRepo.deleteById(id);
	}

	/**
	 * Crop image.
	 *
	 * @param id the id
	 * @return the photo
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Photo CropImage(String id) throws IOException {
		Photo p1 = photoRepo.findById(id).get();
		byte[] Im = p1.getImage().getData();
		ByteArrayInputStream bais = new ByteArrayInputStream(Im);
		BufferedImage bf = ImageIO.read(bais);
		BufferedImage crop = bf.getSubimage(300, 300, 200, 200);
		System.out.println(crop);
		File outputfile = new File("C:/Users/Dom/Desktop/anhdat123.jpg");
		ImageIO.write(crop, "jpg", outputfile);
		System.out.println("Image cropped successfully: " + outputfile.getPath());

		return p1;
	}

	/**
	 * Compare image.
	 *
	 * @param idimage1 the idimage 1
	 * @param idimage2 the idimage 2
	 * @return the double
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public double CompareImage(String idimage1, String idimage2) throws IOException {
		double result = 0;

		Photo image1 = photoRepo.findById(idimage1).get();
		byte[] Im1 = image1.getImage().getData();
		ByteArrayInputStream bais1 = new ByteArrayInputStream(Im1);
		BufferedImage imgA = ImageIO.read(bais1);
		Photo image2 = photoRepo.findById(idimage2).get();
		byte[] Im2 = image2.getImage().getData();
		ByteArrayInputStream bais2 = new ByteArrayInputStream(Im2);
		BufferedImage imgB = ImageIO.read(bais2);
		int width1 = imgA.getWidth();
		int width2 = imgB.getWidth();
		int height1 = imgA.getHeight();
		int height2 = imgB.getHeight();

		if ((width1 != width2) || (height1 != height2))
			System.out.println("Error: Images dimensions" + " mismatch");
		else {
			long difference = 0;
			for (int y = 0; y < height1; y++) {
				for (int x = 0; x < width1; x++) {
					int rgbA = imgA.getRGB(x, y);
					int rgbB = imgB.getRGB(x, y);
					int redA = (rgbA >> 16) & 0xff;
					int greenA = (rgbA >> 8) & 0xff;
					int blueA = (rgbA) & 0xff;
					int redB = (rgbB >> 16) & 0xff;
					int greenB = (rgbB >> 8) & 0xff;
					int blueB = (rgbB) & 0xff;
					difference += Math.abs(redA - redB);
					difference += Math.abs(greenA - greenB);
					difference += Math.abs(blueA - blueB);
				}
			}

			// Total number of red pixels = width * height
			// Total number of blue pixels = width * height
			// Total number of green pixels = width * height
			// So total number of pixels = width * height * 3
			double total_pixels = width1 * height1 * 3;

			// Normalizing the value of different pixels
			// for accuracy(average pixels per color
			// component)
			double avg_different_pixels = difference / total_pixels;

			// There are 255 values of pixels in total
			result = (avg_different_pixels / 255) * 100;

			System.out.println("Difference Percentage-->" + result);
		}
		return result;
	}

	/**
	 * Gets the imagecheckinci.
	 *
	 * @param idpole the idpole
	 * @param date the date
	 * @param crop the crop
	 * @return the imagecheckinci
	 */
	public List<String> getimagecheckinci(String idpole, String date, boolean crop) {
		List<Photo> list = photoRepo.findBydateCreate(date);
		List<String> result = new ArrayList<>();
		for (Photo p : list) {
			if (p.getIdpole().equals(idpole) && crop == p.isCrop()) {
				result.add(p.get_id());
			}

		}
		return result;

	}

	/**
	 * Autocheckinci.
	 *
	 * @return the list
	 * @throws ParseException the parse exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public List<String> autocheckinci() throws ParseException, IOException {
		List<String> result = new ArrayList<>();
		Date today = new Date();
		long long_today = formatter.parse(formatter.format(today)).getTime();
		String string_today = formatter.format(today);
		if (long_today - long_today_server != 0) {
			long_today_server = long_today;
			listid_autocheck.clear();
		}
		List<Photo> list1 = photoRepo.findBydateImport(string_today);
		List<Photo> list_standard = photoRepo.findBydateImport(date_autocheckinci_standard);
		List<Photo> list2 = new ArrayList<>();
		List<Photo> list_y_choice = new ArrayList<>();
		for (Photo photo1 : list1) {
			if (photo1.isCrop()) {
				list2.add(photo1);
			}
		}
		for (Photo photo_standard : list_standard) {
			if (photo_standard.isCrop()) {
				list_y_choice.add(photo_standard);
			}
		}
		int index = 0;
		int dem = 0;
		for (Photo photo2 : list2) {
			int done = 0;
			if (listid_autocheck.isEmpty()) {
				done = 1;
			} else {
				for (String check : listid_autocheck) {
					if (photo2.get_id().equals(check)) {
						list2.remove(index);
						done = 0;
						break;
					} else {
						done = 1;
					}
				}
			}

			if (done == 1) {
				index++;
				for (Photo p : list_y_choice) {
					if (p.getIdpole().equals(photo2.getIdpole()) && p.getTitle().equals(photo2.getTitle()) && p.getType().equals(photo2.getType())) {
						if (CompareImage(photo2.get_id(), p.get_id()) > 2) {
							result.add(photo2.get_id());
							dem++;
							// add Incident
							final String uri = "http://localhost:8082/incidents";

							Incident incident = new Incident("Sự cố tự động " + dem, "Sự cố tự động " + dem,
									string_today, "wait", "4", "detect auto", photo2.getIdpole(), photo2.get_id());

							RestTemplate restTemplate = new RestTemplate();
							String result_post = restTemplate.postForObject(uri, incident, String.class);

							System.out.println(result_post.toString());
							listid_autocheck.add(photo2.get_id());
						}
					}
				}
			}
		}
		return result;
	}

}
