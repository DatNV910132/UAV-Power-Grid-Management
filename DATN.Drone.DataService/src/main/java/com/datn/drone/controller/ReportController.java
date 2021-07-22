/*
 * 
 */
package com.datn.drone.controller;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.datn.drone.model.Report;
import com.datn.drone.repositories.ReportRepository;
// TODO: Auto-generated Javadoc

/**
 * The Class ReportController.
 */
@Service
public class ReportController {
	
	/** The repository. */
	@Autowired
	private ReportRepository repository;

	/**
	 * Gets the all reports.
	 *
	 * @return the all reports
	 */
	public List<Report> getAllReports() {
		return repository.findAll();
	}

	/**
	 * Gets the report by id.
	 *
	 * @param id the id
	 * @return the report by id
	 */
	public Report getReportById(ObjectId id) {
		return repository.findBy_id(id);
	}

	/**
	 * Modify report by id.
	 *
	 * @param id the id
	 * @param Reports the reports
	 */
	public void modifyReportById(ObjectId id, Report Reports) {
		Reports.set_id(id);
		repository.save(Reports);
	}

	/**
	 * Creates the report.
	 *
	 * @param Reports the reports
	 * @return the report
	 */
	public Report createReport(Report Reports) {
		Reports.set_id(ObjectId.get());
		repository.save(Reports);
		return Reports;
	}

	/**
	 * Delete report.
	 *
	 * @param id the id
	 */
	public void deleteReport(ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}
}
