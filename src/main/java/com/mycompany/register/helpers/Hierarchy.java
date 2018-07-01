package com.mycompany.register.helpers;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mycompanyname.register.model.Employee;

public class Hierarchy {
	
	static String emp = "";
	
	public void initHirearchy(){
		emp = "";
	}
	
	public  String GetHierarchy(List<Employee> empList, long empId) {
		 for(Employee e : empList){
			 if ( e!= null && e.getId() == empId){
				 emp = emp + e.getFirstName() + "->";
				 if(e.getId() != 0){
				 GetHierarchy(empList,e.getManager_id());
				 }
			 }
			 
		 }
	
		 return emp.length()>2 ?emp.substring(0,emp.length()-2): emp;
		
	} 

}
