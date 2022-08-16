package com.Api.Employee.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Api.Employee.dao.EmployeeDao;
import com.Api.Employee.entity.EmployeeEntity;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeDao employeeDao;
	
	@GetMapping(path = "/allEmployees", produces = MediaType.APPLICATION_JSON_VALUE )
	public HashMap<String, Object> getAllEmployees() {
	
		HashMap allEmployees = employeeDao.getAllEmployees();
		return allEmployees;
	}
	
	@PostMapping(path = "/addEmployee")
    public HashMap addDistrictData(@RequestBody EmployeeEntity employeeentity){
        return employeeDao.addEmployee(employeeentity);
    } 
	
}
