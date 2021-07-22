/*
 * 
 */
package com.datn.drone.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.datn.drone.model.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmployeeRepository.
 */
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	
	/**
	 * Find Employee or List Emp by id.
	 *
	 * @param _id the id
	 * @return Employee
	 */
	Employee findBy_id(ObjectId _id);
	
	/**
	 * Find Employee or List Emp byusername.
	 *
	 * @param username the username
	 * @return Employee
	 */
	Employee findByusername(String username);
	
	/**
	 * Find Employee or List Emp byidrole.
	 *
	 * @param idrole the idrole
	 * @return List Employee
	 */
	List<Employee> findByidrole(String idrole);
	
	/**
	 * Find Employee or List Emp by name.
	 *
	 * @param name the name
	 * @return List Employee
	 */
	List<Employee> findByname(String name);
	
	/**
	 * Find Employee or List Emp bybirth.
	 *
	 * @param birth the birth
	 * @return List Employee
	 */
	List<Employee> findBybirth(String birth);
	
	/**
	 * Find Employee or List Emp bysex.
	 *
	 * @param sex the sex
	 * @return List Employee
	 */
	List<Employee> findBysex(String sex);
	
	/**
	 * Find Employee or List Emp bynationid.
	 *
	 * @param nationid the nationid
	 * @return Employee
	 */
	Employee findBynationality(String nationality);
	
	/**
	 * Find Employee or List Emp byaddress.
	 *
	 * @param address the address
	 * @return List Employee
	 */
	List<Employee> findByaddress(String address);
	
	/**
	 * Find Employee or List Emp bymail.
	 *
	 * @param mail the mail
	 * @return Employee
	 */
	Employee findBymail(String mail);
	
	/**
	 * Find Employee or List Emp byphone.
	 *
	 * @param phone the phone
	 * @return Employee
	 */
	Employee findByphone(String phone);
}
