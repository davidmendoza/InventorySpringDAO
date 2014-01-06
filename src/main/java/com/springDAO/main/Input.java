package com.springDAO.main;

import java.util.List;
import java.util.Scanner;

import com.springDAO.dao.ItemDAO;
import com.springDAO.model.Item;

public class Input {
	
    public static void addItem(ItemDAO itemDao){
    	Scanner sc = new Scanner(System.in);
		String name;
		int quantity;
		float price;
		Item item = new Item();	
		
		System.out.println("\tAdd new Item");
		System.out.print("\tEnter Item Name --> ");
		name = sc.nextLine().toUpperCase().trim();
		System.out.print("\tEnter price --> ");
		price = Menu.checkIntInput(sc);
		System.out.print("\tEnter quantity --> ");
		quantity = Menu.checkIntInput(sc);
		
	    item.setName(name);
	    item.setPrice(price);
	    item.setQuantity(quantity);
	    
	    itemDao.createItem(item);
	    System.out.println("\tNew item created");
    }

	public static void editItem(ItemDAO itemDao) {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int id;
		String name;
		int quantity;
		float price;
		
		System.out.println("\tEdit Item");
		System.out.print("\tEnter Item Id --> ");
		id = Menu.checkIntInput(sc);
		Item item = (Item)itemDao.getItemById(id);
		System.out.println("\tItem to be edited: ");
		System.out.println("\t"+item.getName()+" - "+item.getPrice()+" - "+item.getQuantity());
		
		System.out.print("\tEnter Item Name --> ");
		name = sc2.nextLine().toUpperCase().trim();
		System.out.print("\tEnter price --> ");
		price = Menu.checkIntInput(sc);
		System.out.print("\tEnter quantity --> ");
		quantity = Menu.checkIntInput(sc);
		
	    item.setName(name);
	    item.setPrice(price);
	    item.setQuantity(quantity);
	    
	    itemDao.editItem(item);
	    System.out.println("\tItem Edited");
		
	}

	public static void deleteItem(ItemDAO itemDao) {
		Scanner sc = new Scanner(System.in);
		int id;
		
		System.out.println("\tDelete Item");
		System.out.print("\tEnter Item Id --> ");
		id = Menu.checkIntInput(sc);
		itemDao.deleteItem(id);
		System.out.println("\tItem Deleted");
		
	}

	public static void printItems(ItemDAO itemDao) {
		
		List<Item> items = itemDao.getItems();
		System.out.println("\tID - NAME - PRICE - QUANTITY");
		for(Item item: items){
			System.out.println("\t"+item.getId()+" - "+item.getName()+" - "+item.getPrice()+" - "+item.getQuantity());
		}
		
	}

}
