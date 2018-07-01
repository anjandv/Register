package com.mycompanyname.register.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompanyname.register.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}