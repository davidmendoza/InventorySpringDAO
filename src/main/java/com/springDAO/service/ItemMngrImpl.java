package com.springDAO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springDAO.dao.ItemDAO;
import com.springDAO.model.Item;

@Service
public class ItemMngrImpl implements ItemMngr {
    
	@Autowired
	private ItemDAO itemDAO;
	
	@Override
	@Transactional
	public void createItem(Item item) {
		itemDAO.createItem(item);

	}

	@Override
	@Transactional
	public Item getItemById(int id) {
		return itemDAO.getItemById(id);
	}

	@Override
	@Transactional
	public Item getItemByName(String name) {
		return itemDAO.getItemByName(name);
	}

	@Override
	@Transactional
	public List<Item> getItems() {
		return itemDAO.getItems();
	}

}
