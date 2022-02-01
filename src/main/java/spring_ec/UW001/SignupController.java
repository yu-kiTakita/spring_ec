package spring_ec.UW001;

import java.util.Map;

import javax.persistence.PostRemove;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring_ec.UW001.Service.UserApplicationService;

@Controller
@RequestMapping("/user")
public class SignupController {
	
	Logger log = LoggerFactory.getLogger(SignupController.class);
	
	@Autowired
	private UserApplicationService service;
	
	//ユーザー登録画面を表示
	@GetMapping("/signup")
	public String getSingup(Model model) {
		log.info("get: singup");
		//性別を取得
		Map<String, Integer> genderMap = service.getGenderMap();
		model.addAllAttributes(genderMap);
		
		//ユーザーに遷移
		return "user/signup";
	}
	
	//ユーザー登録画面に遷移
	@PostMapping("/signup")
	public String postSignup() {
		log.info("post: singup");
		//ログイン画面にリダイレクト(PRG)
		return "redirect:/login";
	}

}
