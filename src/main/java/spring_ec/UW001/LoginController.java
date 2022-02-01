package spring_ec.UW001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	Logger log = LoggerFactory.getLogger(LoginController.class);
	
	//ÉçÉOÉCÉìâÊñ ÇÃï\é¶
	@GetMapping("/login")
	public String getLogin() {
		log.info("login");
		return "login/userLogin";
	}
	
}
