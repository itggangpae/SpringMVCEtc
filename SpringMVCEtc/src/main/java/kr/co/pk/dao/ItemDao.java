package kr.co.pk.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.pk.domain.Item;

@Repository
public class ItemDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Item> getAll() {
		return (List<Item>)sessionFactory.getCurrentSession().createCriteria(Item.class).list();
	}

	public Item getItem(Integer itemid) {
		Item item = (Item)sessionFactory.getCurrentSession().get(Item.class, itemid);
		return item;
	}

}
