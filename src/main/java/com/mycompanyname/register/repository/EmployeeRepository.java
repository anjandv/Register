package com.mycompanyname.register.repository;



import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompanyname.register.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}