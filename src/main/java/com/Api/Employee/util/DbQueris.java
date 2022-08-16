package com.Api.Employee.util;

public class DbQueris {
	public static String getEmployees()
	{
		return "select * from emp.employee";
	}
	public static String addEmployee() {
		return "insert into emp.employee(emid , ename) values (?,?)";
	}
}
