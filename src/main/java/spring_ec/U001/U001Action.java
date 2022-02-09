package spring_ec.U001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.util.StringUtils;

import spring_ec.UW001.SignupController;

@Controller
public class U001Action {
	
	@Autowired
	private U001Facade facade;
	
	Logger log = LoggerFactory.getLogger(SignupController.class);
	
	@GetMapping("/Index")
	public String getIndex(Model model) {
		
		log.info("U001Action_Index_start");
		if(StringUtils.isEmpty((String)model.getAttribute("KeyWorld"))) {
			//商品情報を取得
			model.addAttribute("itemList", facade.serchItem());
		}
		log.info("U001Action_Index_End");
		return "U001/Index";
	}
}