/*
 * 
 */
package com.datn.drone.server;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.datn.drone.controller.ReportController;
import com.datn.drone.model.Report;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportServer.
 */
@RestController
@RequestMapping("/reports")
public class ReportServer {
	
	/** The report controller. */
	@Autowired
	private ReportController reportController;

	/**
	 * Gets the all reports.
	 *
	 * @return the all reports
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Report> getAllReports() {
		return reportController.getAllReports();
	}

	/**
	 * Gets the report by id.
	 *
	 * @param id the id
	 * @return the report by id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Report getReportById(@PathVariable("id") ObjectId id) {
		return reportController.getReportById(id);
	}

	/**
	 * Modify report by id.
	 *
	 * @param id the id
	 * @param Reports the reports
	 * @return the response entity
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> modifyReportById(@PathVariable("id") ObjectId id,
			@Valid @RequestBody Report Reports) {
		reportController.modifyReportById(id, Reports);
		return new ResponseEntity<>("Sửa báo cáo thành công", HttpStatus.OK);

	}

	/**
	 * Creates the report.
	 *
	 * @param Reports the reports
	 * @return the report
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Report createReport(@Valid @RequestBody Report Reports) {
		return reportController.createReport(Reports);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable ObjectId id) {
		reportController.deleteReport(id);
		return new ResponseEntity<>("Xóa báo cáo thành công", HttpStatus.OK);
	}
}
