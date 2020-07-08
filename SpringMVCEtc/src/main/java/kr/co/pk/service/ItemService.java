package kr.co.pk.service;

import java.util.List;

import kr.co.pk.domain.Item;

public interface ItemService {
	public List<Item> getAll(); 
	public Item getItem(Integer itemid);
}
