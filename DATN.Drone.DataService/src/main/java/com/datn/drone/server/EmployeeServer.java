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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.datn.drone.controller.EmployeeController;
import com.datn.drone.controller.Role_LinkController;
import com.datn.drone.exception.NotFoundException;
import com.datn.drone.model.Employee;
import com.datn.drone.model.Role_Link;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeServer.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeServer {
	
	/** The employee controller. */
	@Autowired
	private EmployeeController employeeController;
	
	/** The role linkcontroller. */
	@Autowired
	private Role_LinkController role_linkcontroller;
	

	/**
	 * Restful API Gets the allemployees.
	 *
	 * @param code the code
	 * @return the allemployees
	 */
	@RequestMapping(value = "/getall/", method = RequestMethod.GET)
	public List<Employee> getAllemployees(@RequestParam("code") String code) {
		boolean check = false;
		List<Employee> employees = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		if(check) {
			employees = employeeController.getAllemployees();
			
		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (employees == null && check) {
			throw new NotFoundException();
		}
		return employees;
		
	}

	/**
	 * Restful API Gets the emp by id.
	 *
	 * @param id the id
	 * @param code the code
	 * @return the emp by id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getEmpById(@PathVariable("id") ObjectId id,@RequestParam("code") String code) {
		boolean check = false;
		Employee result = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		if(check) {
			result = employeeController.getEmpById(id);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (result == null && check) {
			throw new NotFoundException();
		}
		return result;
	}

	/**
	 * Restful API Gets the emp byusername.
	 *
	 * @param username the username
	 * @return the emp byusername
	 */
	@RequestMapping(value = "/username/", method = RequestMethod.GET)
	public Employee getEmpByusername(@RequestParam("username") String username) {
		Employee result = null;
		
			result = employeeController.getEmpByusername(username);
			
		if (result == null) {
			throw new NotFoundException();
		}
		return result;
	}

	/**
	 * Restful API Gets the emp bynationid.
	 *
	 * @param nationid the nationid
	 * @param code the code
	 * @return the emp bynationid
	 */
	@RequestMapping(value = "/nationality/", method = RequestMethod.GET)
	public Employee getEmpBynationid(@RequestParam("nationality") String nationality, @RequestParam("code") String code) {
		
		boolean check = false;
		Employee result = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		if(check) {
			result = employeeController.getEmpBynationality(nationality);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (result == null && check) {
			throw new NotFoundException();
		}
		return result;
		
	}

	/**
	 * Restful API Gets the emp bymail.
	 *
	 * @param mail the mail
	 * @param code the code
	 * @return the emp bymail
	 */
	@RequestMapping(value = "/mail/", method = RequestMethod.GET)
	public Employee getEmpBymail(@RequestParam("mail") String mail, @RequestParam("code") String code) {
		
		boolean check = false;
		Employee result = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		if(check) {
			result = employeeController.getEmpBymail(mail);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (result == null && check) {
			throw new NotFoundException();
		}
		return result;
	}

	/**
	 * Restful API Gets the emp byphone.
	 *
	 * @param phone the phone
	 * @param code the code
	 * @return the emp byphone
	 */
	@RequestMapping(value = "/phone/", method = RequestMethod.GET)
	public Employee getEmpByphone(@RequestParam("phone") String phone, @RequestParam("code") String code) {
		
		boolean check = false;
		Employee result = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		if(check) {
			result = employeeController.getEmpByphone(phone);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (result == null && check) {
			throw new NotFoundException();
		}
		return result;
	}

	/**
	 * Restful API Gets the emp byname.
	 *
	 * @param name the name
	 * @param code the code
	 * @return the emp byname
	 */
	@RequestMapping(value = "/name/", method = RequestMethod.GET)
	public List<Employee> getEmpByname(@RequestParam("name") String name, @RequestParam("code") String code) {
		
		boolean check = false;
		List<Employee> result = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		if(check) {
			result = employeeController.getEmpByname(name);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (result == null && check) {
			throw new NotFoundException();
		}
		return result;
	}

	/**
	 * Restful API Gets the emp bybirth.
	 *
	 * @param birth the birth
	 * @param code the code
	 * @return the emp bybirth
	 */
	@RequestMapping(value = "/birth/", method = RequestMethod.GET)
	public List<Employee> getEmpBybirth(@RequestParam("birth") String birth, @RequestParam("code") String code) {
		
		boolean check = false;
		List<Employee> result = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		if(check) {
			result = employeeController.getEmpBybirth(birth);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (result == null && check) {
			throw new NotFoundException();
		}
		return result;
	}

	/**
	 * Restful API Gets the emp bysex.
	 *
	 * @param sex the sex
	 * @param code the code
	 * @return the emp bysex
	 */
	@RequestMapping(value = "/sex/", method = RequestMethod.GET)
	public List<Employee> getEmpBysex(@RequestParam("sex") String sex, @RequestParam("code") String code) {
		
		boolean check = false;
		List<Employee> result = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		if(check) {
			result = employeeController.getEmpBysex(sex);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (result == null && check) {
			throw new NotFoundException();
		}
		return result;
		
	}

	/**
	 * Restful API Modify emp by id.
	 *
	 * @param id the id
	 * @param employees the employees
	 * @param code the code
	 * @return the response entity
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> modifyEmpById(@PathVariable("id") ObjectId id,
			@Valid @RequestBody Employee employees, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		
		if(check) {
			employeeController.modifyEmpById(id, employees);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}
		return new ResponseEntity<>("Sửa thông tin nhân viên thành công", HttpStatus.OK);
	}

	/**
	 * Restful API  Creates the emp.
	 *
	 * @param employees the employees
	 * @param code the code
	 * @return true, if successful
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean createEmp(@Valid @RequestBody Employee employees, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		
		if(check) {
			employeeController.createEmp(employees);
		} else {
			throw new NotFoundException("Permission Denied");
		}
		
		return true;
	}

	/**
	 * Restful API  Delete emp.
	 *
	 * @param id the id
	 * @param code the code
	 * @return the response entity
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEmp(@PathVariable ObjectId id, @RequestParam("code") String code) {
		
		boolean check = false;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		
		if(check) {
			employeeController.deleteEmp(id);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}		
		
		return new ResponseEntity<>("Xóa thông tin nhân viên thành công", HttpStatus.OK);
	}

	/**
	 * Restful API  Sendforgetmail.
	 *
	 * @param phone the phone
	 * @return the response entity
	 */
	@RequestMapping(value = "/resetpwd/", method = RequestMethod.GET)
	public ResponseEntity<String> sendforgetmail(@RequestParam String phone) {
		employeeController.sendforgetmail(phone);
		return new ResponseEntity<>("Gửi Email phục hồi thành công", HttpStatus.OK);
	}
	
	/**
	 * Restful API Gets the empby role.
	 *
	 * @param role the role
	 * @param code the code
	 * @return the empby role
	 */
	@RequestMapping(value = "/role/", method = RequestMethod.GET)
	public List<Employee> getempbyRole(@RequestParam("role") String role, @RequestParam("code") String code){
		
		boolean check = false;
		List<Employee> employees = null;
		Role_Link role_links = role_linkcontroller.getbycode(code);
		
		if(role_links != null) {
			check = true;
		}
		if(check) {
			employees = employeeController.getbyrole(role);
			
		} else {
			throw new NotFoundException("Permission Denied");
		}
		if (employees == null && check) {
			throw new NotFoundException();
		}
		return employees;
		
		
	}
}
