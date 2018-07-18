package org.inetsolv.SpringJdbcRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEid(rs.getInt("eno"));
		employee.setEname(rs.getString("ename"));
		employee.setSalary(rs.getDouble("salary"));
		return employee;
	}
}