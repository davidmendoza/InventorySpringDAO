package com.springDAO.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springDAO.model.Item;

@Service
public class ItemImpl implements ItemDAO{
    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void createItem(Item item) {
		sessionFactory.getCurrentSession().save(item);
		
	}

	@Override
	@Transactional
	public Item getItemById(int id) {
		return (Item)sessionFactory.getCurrentSession().get(Item.class, id);
	}
	
	@Override
	@Transactional
	public List<Item> getItems() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Item");
		return query.list();
	}

	@Override
	@Transactional
	public void deleteItem(int id) {
		Session session = sessionFactory.getCurrentSession();
		Item item = (Item)session.get(Item.class, id);
		session.delete(item);
	}

	@Override
	@Transactional
	public void editItem(Item item) {
		sessionFactory.getCurrentSession().update(item);
		
	}
	

}
