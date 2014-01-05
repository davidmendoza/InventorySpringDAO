package com.springDAO.service;

import java.util.List;

import com.springDAO.model.Item;

public interface ItemMngr {
	
    void createItem(Item item);
    
    Item getItemById(int id);
    
    Item getItemByName(String name);
    
    List<Item> getItems();
}
