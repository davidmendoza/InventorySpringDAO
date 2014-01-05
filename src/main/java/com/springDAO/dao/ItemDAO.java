package com.springDAO.dao;

import java.util.List;

import com.springDAO.model.Item;

public interface ItemDAO {

    void createItem(Item item);
    
    Item getItemById(int id);
    
    Item getItemByName(String name);
    
    List<Item> getItems();
}
