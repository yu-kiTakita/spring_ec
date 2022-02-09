package spring_ec.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import spring_ec.Bean.ItemBean;

@Repository
public class ItemDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	/*
	 * 商品IDによる商品検索
	 * @param itemId
	 */
	public ArrayList<ItemBean> getRandItem(int limit) {

		String query = "SELECT * FROM m_item ORDER BY RAND() LIMIT ? ";
		List<Map<String, Object>> list = new ArrayList<>();
		list = jdbc.queryForList(query, limit);
		return RefillToItemList(list);
	}
	
	/*
	 * 商品IDによる商品検索
	 * @param itemId
	 */
	public ArrayList<ItemBean> getItemByItemID(int itemId) {
		
		List<Map<String, Object>> list = new ArrayList<>();
		String query = "SELECT * FROM m_item WHERE id = ?";
		list = jdbc.queryForList(query, itemId);
		ArrayList<ItemBean> result = RefillToItemList(list);
		return result;
	}

	/*
	 * 商品検索
	 * @param searchWord
	 * @param pageNum
	 * @param pageMaxItemCount
	 */
	public ArrayList<ItemBean> getItemsItemName(String searchWord, int pageNum, int pageMaxItemCount) {
		
		List<Map<String, Object>> list = new ArrayList<>();
		int startiItemNum = (pageNum - 1) * pageMaxItemCount;
		
		if(StringUtils.isEmpty(searchWord)) {
			//全検索
			String query = "SELECT * FROM m_item ORDER BY id ASC LIMIT ?,? ";
			int[] bind = {startiItemNum,pageMaxItemCount};
			list = jdbc.queryForList(query, bind);
		}else {
			//商品名検索
			String query = "SELECT * FROM m_item WHERE name LIKE ?  ORDER BY id ASC LIMIT ?,? ";
			Object[] bind = {"%"+searchWord+"%",startiItemNum,pageMaxItemCount};
			list = jdbc.queryForList(query, bind);
		}
		ArrayList<ItemBean> result = RefillToItemList(list);
		return result;
	}
	
	/*
	 * 商品総数を取得
	 *
	 * @param searchWord
	 */
	public double getItemCount(String searchWord) {
		
		List<Map<String, Object>> list = new ArrayList<>();
		String query = "select count(*) as cnt from m_item where name like ?";
		Object[] bind = {"%"+searchWord+"%"};
		list = jdbc.queryForList(query, bind);
		return list.size();
	}
	
	/*
	 * Mapからbeanに詰めなおす
	 */
	private ArrayList<ItemBean> RefillToItemList(List<Map<String, Object>> itemLists) {
		Iterator<Map<String, Object>> iterator = itemLists.listIterator();
		ArrayList<ItemBean> itemList = new ArrayList<ItemBean>();
		while (iterator.hasNext()) {
			ItemBean item = new ItemBean();
			Map<String,Object> items = iterator.next();
			item.setId((Integer) items.get("id"));
			item.setName((String) items.get("name"));
			item.setDetail((String) items.get("detail"));
			item.setPrice((Integer) items.get("price"));
			item.setFileName((String) items.get("file_name"));
			itemList.add(item);
		}
		return itemList;
	}
}