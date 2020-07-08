package kr.co.pk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.co.pk.domain.Item;


public interface ItemMapper {
	@Select(
			"select itemid, itemname, price, description, pictureurl "
			+ "from item")
	public List<Item> allitem();
	
	@Select(
			"select itemid, itemname, price, description, pictureurl "
			+ "from item where itemid = #{itemid}")
	public Item detailitem(Integer itemid);
	
}
