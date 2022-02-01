package spring_ec.Employee;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repositry;
	
	public Employee getEmployee(String id) {
		
		//åüçı
		Map<String,Object> map = repositry.findById(id);
		
		Employee employee = new Employee();
		
		employee.setEmployeeId((String)map.get("id"));
		employee.setEmployeeName((String)map.get("name"));
		employee.setEmployeeAge((Integer)map.get("age"));
		
		return employee;
	}
}
