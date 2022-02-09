package spring_ec.U001;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_ec.Bean.ItemBean;

@Service
public class U001Facade {
	@Autowired
	private U001Logic logic;
	
	public ArrayList<ItemBean> serchItem() {
		return logic.searchTopItem();
	}
	
}
