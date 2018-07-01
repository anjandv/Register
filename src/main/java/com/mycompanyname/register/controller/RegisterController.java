package com.mycompanyname.register.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompanyname.register.exception.ResourceNotFoundException;
import com.mycompanyname.register.model.Employee;
import com.mycompanyname.register.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class RegisterController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	// 1. Add an employee
	
	@PostMapping("/employee")
	public Employee CreateNote(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	
	
	// 2. Get details of an employee
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") Long empId) {
		return employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee","id", empId));
	}
	
	// 3. Get all employee
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	// 4. Update details of an employee
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable(value = "id") Long empId, @Valid @RequestBody Employee employeeDetails) {
		
		Employee employee = employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setDesignation(employeeDetails.getDesignation());
		employee.setManager_id(employeeDetails.getManager_id());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		
		return updatedEmployee;
		
		
	}
	
	
	// 5. Get hierarchy of an employee
//	@GetMapping("/employee/hierarchy/{id}")
//	//@Query("WITH RECURSIVE employee_path(id,firstName,manager_id) AS (SELECT id,,firstName,manager_id FROM employee WHERE id = :eId UNION ALL SELECT e.id,e.firstName,e.manager_id FROM employee_path AS cp JOIN Employee AS e ON cp.manager_id = e.id)SELECT * FROM employee_path ORDER by bid ASC")
//	public String getHierarchy(@PathVariable(value = "id") Long empId) {
//		List<Employee> emplist = new ArrayList<Employee>();
//		
//		emplist = employeeRepository.findHierarchy(empId);
//		
//		return emplist.toString();
//	}
	
	// 6. Delete an employee
	
	 @DeleteMapping("/employee/{id}")
	 public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long empId){
		 
		 Employee employee = employeeRepository.findById(empId).orElseThrow(() ->  new ResourceNotFoundException("Employee", "id", empId)); 
		 
		 employeeRepository.delete(employee);
		 
		 return ResponseEntity.ok().build();
		 
	 }
	
	 @PostMapping("/employeeList")
	 public List<Employee> createEmployeeList(@Valid @RequestBody List<Employee> employeeList){
		 return employeeRepository.saveAll(employeeList);
	 }
	
}
