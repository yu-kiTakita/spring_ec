package spring_ec.U001;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_ec.Bean.ItemBean;
import spring_ec.Dao.ItemDao;

@Service
public class U001Logic {
	
	@Autowired
	private ItemDao itemDao;
	
	/*
	 * TOP画面に表示する商品を取得する
	 */
	public ArrayList<ItemBean>searchTopItem(){
		ArrayList<ItemBean> itemList = itemDao.getRandItem(U001Constant.SerchIndexCount);
		return itemList;
	}
}