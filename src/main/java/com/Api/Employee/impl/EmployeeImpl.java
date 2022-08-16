package com.Api.Employee.impl;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.Api.Employee.dao.EmployeeDao;
import com.Api.Employee.entity.EmployeeEntity;
import com.Api.Employee.util.DbQueris;

@Repository
public class EmployeeImpl extends JdbcDaoSupport implements EmployeeDao {
	
	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public HashMap getAllEmployees() {
		HashMap<String, Object> result = new HashMap<>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String Query = DbQueris.getEmployees();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(Query);
		result.put("Employee Details", rows);
		return result;
	}

	@Override
	public HashMap addEmployee(EmployeeEntity employeeEntity) {
		HashMap<String, Object> result = new HashMap<>();
		JdbcTemplate template = new JdbcTemplate(dataSource);
		Object[] params = {employeeEntity.getEmid(), employeeEntity.getEname()};
		int[] types = { Types.INTEGER, Types.VARCHAR};
		int rows = template.update(DbQueris.addEmployee(), params, types);
		result.put("Inserted Successfully", "201");
		return result;
	}

}
