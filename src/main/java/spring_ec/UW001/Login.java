package spring_ec.UW001;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring_ec.Employee.Employee;
import spring_ec.Employee.EmployeeService;

@Controller
public class Login {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/test")
	public String getlogin() {
		return "test";
	}

	@PostMapping("/test")
	public String postRequest(@RequestParam("text1") String str, Model model) {

		// ‰æ–Ê‚©‚çó‚¯æ‚Á‚½•¶š—ñ‚ğmodel‚É“o˜^
		model.addAttribute("sample", str);

		// response.html‚É‘JˆÚ
		return "response";
	}
	
	@PostMapping("/db")
	public String pstDbRequest(@RequestParam("text2")String id,Model model) {
		
		//ŒŸõ
		Employee employee = service.getEmployee(id);
		
		//ŒŸõŒ‹‰Ê‚ğ’Ç‰Á
		model.addAttribute("employee", employee);
		
		return "db";
		
	}
}
