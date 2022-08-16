package com.Api.Employee.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.Api.Employee.entity.EmployeeEntity;

@Repository
public interface EmployeeDao {
  
	public HashMap getAllEmployees();
	public HashMap addEmployee(EmployeeEntity employeeEntity);
}
