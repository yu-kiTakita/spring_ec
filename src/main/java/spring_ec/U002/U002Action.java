package spring_ec.U002;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring_ec.UW001.SignupController;

@Controller
public class U002Action {

	@Autowired
	private U002Facade facade;

	Logger log = LoggerFactory.getLogger(SignupController.class);

	@RequestMapping("/ItemSearchResult")
	public String ItemSearch(Model model) {

		log.info("U002Action_Index_start");
		
		String serchWorld = (String)model.getAttribute("search_word");
		int pageNum = model.getAttribute("page_num") == null ? 1 : (Integer) model.getAttribute("page_num");
		
		//総数アイテム
		model.addAttribute("itemCount", (int)facade.totalNumberOfItems(serchWorld));
		
		//商品リストを取得 ページ表示分のみ
		model.addAttribute("itemList", facade.serchItem(serchWorld, pageNum));
		
		// 検索ワードに対しての総ページ数を取得
		model.addAttribute("pageMax", facade.totalNumberOfPages(serchWorld));
		
		//表示ページ
		model.addAttribute("pageNum", pageNum);
		
		log.info("U002Action_Index_End");
		return "ItemSearchResult";
	}
}
