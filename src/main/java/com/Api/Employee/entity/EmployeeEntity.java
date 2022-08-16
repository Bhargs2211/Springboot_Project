package com.Api.Employee.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeEntity {
	private int emid;
	private String ename;
	public int getEmid() {
		return emid;
	}
	public void setEmid(int emid) {
		this.emid = emid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
}
