package org.inetsolv.SpringJdbcRowMapper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
	private static JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		ApplicationContext container=new ClassPathXmlApplicationContext("spring.xml");
		jdbcTemplate = container.getBean(JdbcTemplate.class);
		String qry="SELECT * FROM emp_tbl";
		List<Employee> empList = jdbcTemplate.query(qry, new EmployeeRowMapper());
		for (Employee employee : empList) {
			System.out.println(employee.getEno()+" "+employee.getEname()+" "+employee.getSalary());
		}
/*		//To get the count of employees
		String sql="SELECT COUNT(*) FROM emp_tbl";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println("No of employees: "+count);
*/		
		((AbstractApplicationContext)container).close();
	}
}