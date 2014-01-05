package com.springDAO.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springDAO.model.Item;

@Service
public class ItemImpl implements ItemDAO{
    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createItem(Item item) {
		sessionFactory.getCurrentSession().save(item);
		
	}

	@Override
	public Item getItemById(int id) {
		return (Item)sessionFactory.getCurrentSession().get(Item.class, id);
	}

	@Override
	public Item getItemByName(String name) {
		String hql = "from Item where name = :name";
	    Query query = sessionFactory.getCurrentSession().createQuery(hql);
	    query.setParameter("name", name);
	    return (Item)query.list().get(0);
	}

	@Override
	public List<Item> getItems() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Item");
		return query.list();
	}

}
