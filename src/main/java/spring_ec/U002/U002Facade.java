package spring_ec.U002;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_ec.Bean.ItemBean;

@Service
public class U002Facade {

	@Autowired
	private U002Logic logic;
	
	public ArrayList<ItemBean> serchItem(String serchWord, int pageNum){
		return logic.serchItem(serchWord, pageNum);
	}
	
	public int totalNumberOfPages(String serchWord) {
		return logic.totalNumberOfPages(serchWord);
	}
	
	public double totalNumberOfItems(String serchWord) {
		return logic.totalNumberOfItems(serchWord);
	}
}
