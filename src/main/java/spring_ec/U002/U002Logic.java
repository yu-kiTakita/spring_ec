package spring_ec.U002;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_ec.Bean.ItemBean;
import spring_ec.Dao.ItemDao;

@Service
public class U002Logic {
	
	@Autowired
	private ItemDao itemDao;

	public ArrayList<ItemBean> serchItem(String serchWord, int pageNum) {

		ArrayList<ItemBean> searchResultItemList = itemDao.getItemsItemName(serchWord, pageNum,
				U002Constant.PAGE_MAX_ITEM_COUNT);
		return searchResultItemList;
	}

	public int totalNumberOfPages(String serchWord) {

		double itemCount = itemDao.getItemCount(serchWord);
		int pageMax = (int) Math.ceil(itemCount / U002Constant.PAGE_MAX_ITEM_COUNT);
		return pageMax;
	}

	public double totalNumberOfItems(String serchWord) {

		double itemCount = itemDao.getItemCount(serchWord);
		return itemCount;
	}
}