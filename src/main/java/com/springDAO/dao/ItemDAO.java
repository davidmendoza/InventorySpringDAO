package com.springDAO.dao;

import java.util.List;

import com.springDAO.model.Item;

public interface ItemDAO {

    void createItem(Item item);
    
    Item getItemById(int id);
    
    void deleteItem(int id);
    
    void editItem(Item item);
    
    List<Item> getItems();
}
