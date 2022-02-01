package spring_ec.Employee;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public Map<String,Object>findById(String id){
		//select
		String query = "SELECT * FROM employee WHERE id=?";
		
		//åüçıé¿çs
		Map<String,Object> employee = jdbc.queryForMap(query,id);
		return employee;
	}
}
