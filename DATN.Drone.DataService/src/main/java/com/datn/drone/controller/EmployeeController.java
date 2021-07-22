/*
 * 
 */
package com.datn.drone.controller;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.datn.drone.model.Employee;
import com.datn.drone.model.Role;
import com.datn.drone.repositories.EmployeeRepository;
import com.datn.drone.repositories.RoleRepository;

// TODO: Auto-generated Javadoc
/**
 * Các chức năng điều khiển của nhân viên.
 */
@Service
public class EmployeeController {
	
	/** The repository. */
	@Autowired
	private EmployeeRepository repository;
	
	/** The rolerepository. */
	@Autowired
	private RoleRepository rolerepository;

	/** The java mail sender. */
	@Autowired
	private JavaMailSender javaMailSender;

	/** The secret key. */
	private String secretKey = "@datdeptrai@@@anhxinhdep@@@910132!!!";

	/**
	 * Lấy tất cả thông tin của nhân viên.
	 *
	 * @return the list employee
	 */
	//
	public List<Employee> getAllemployees() {
		return repository.findAll();
	}

	/**
	 * Lấy thông tin của nhân viên theo id nhập vào.
	 *
	 * @param id the id
	 * @return Employee By ID
	 */
	public Employee getEmpById(ObjectId id) {
		return repository.findBy_id(id);
	}

	/**
	 * Lấy thông tin của nhân viên theo username nhập vào.
	 *
	 * @param username the username
	 * @return the emp byusername
	 */
	public Employee getEmpByusername(String username) {
		return repository.findByusername(username);
	}

	/**
	 * Lấy thông tin của nhân viên theo nationid nhập vào.
	 *
	 * @param nationality the nationality
	 * @return the Employee by nationality
	 */
	public Employee getEmpBynationality(String nationality) {
		return repository.findBynationality(nationality);
	}
	
	/**
	 * Lấy thông tin của nhân viên theo mail nhập vào.
	 *
	 * @param mail the mail
	 * @return the employee by mail
	 */
	//
	public Employee getEmpBymail(String mail) {
		return repository.findBymail(mail);
	}
	
	/**
	 * Lấy thông tin của nhân viên theo phone nhập vào.
	 *
	 * @param phone the phone
	 * @return the employee by phone
	 */
	public Employee getEmpByphone(String phone) {
		return repository.findByphone(phone);
	}
	
	/**
	 * Lấy thông tin của nhân viên theo birth nhập vào.
	 *
	 * @param birth the birth
	 * @return the employee by birth
	 */
	//
	public List<Employee> getEmpBybirth(String birth) {
		return repository.findBybirth(birth);
	}
	
	/**
	 * Lấy thông tin của nhân viên theo name nhập vào.
	 *
	 * @param name the name
	 * @return the employee by name
	 */
	public List<Employee> getEmpByname(String name) {
		return repository.findByname(name);
	}
	
	/**
	 * Lấy thông tin của nhân viên theo giới tính nhập vào.
	 *
	 * @param sex the sex
	 * @return the employee by sex
	 */
	public List<Employee> getEmpBysex(String sex) {
		return repository.findBysex(sex);
	}

	/**
	 * Chỉnh sửa thông tin của nhân viên.
	 *
	 * @param id the id
	 * @param employees the employees
	 */
	public void modifyEmpById(ObjectId id, Employee employees) {
		employees.set_id(id);
		repository.save(employees);
	}

	/**
	 * Tạo mới nhân viên.
	 *
	 * @param employees the employees
	 * @return true, if successful
	 */
	public boolean createEmp(Employee employees) {
		employees.set_id(ObjectId.get());
		int check = 0;
		boolean result = false;
		List<Employee> checklist = repository.findAll();
		for (Employee emp : checklist) {
			if (emp.getUsername().equals(employees.getUsername()) || emp.getNationality().equals(employees.getNationality())
					|| emp.mail.equals(employees.getMail()) || emp.getPhone().equals(employees.getPhone())) {
				check++;
			}
		}
		if (check == 0) {
			String pass = AES.encrypt(employees.getPassword(), secretKey);
			employees.setPassword(pass);
			repository.save(employees);
			result = true;
		}
		return result;
	}

	/**
	 * Xóa nhân viên.
	 *
	 * @param id the id
	 */
	public void deleteEmp(ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}

	/**
	 * Chức năng gửi Email để lấy lại mật khẩu khi người dùng quên mật khẩu.
	 *
	 * @param phone the phone
	 */
	public void sendforgetmail(String phone) {
		Employee emp = repository.findByphone(phone);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(emp.getMail());
		msg.setSubject("Lấy lại thông tin người dùng");
		msg.setText("Họ và tên: " + emp.getName() + "\nSố điện thoại: " + emp.getPhone() + "\nTài khoản: "
				+ emp.getUsername() + "\nMật khẩu: " + AES.decrypt(emp.getPassword(), secretKey));

		javaMailSender.send(msg);
	}
	
	/**
	 * Lấy danh sách nhân viên theo Chức vụ, quyền hạn.
	 *
	 * @param role the role
	 * @return the byrole
	 */
	public List<Employee> getbyrole(String role){
		Role role_info = rolerepository.findByrolename(role);
		List<Employee> results = repository.findByidrole(role_info.get_id());
		return results;
		
	}
}