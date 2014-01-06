package com.springDAO.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springDAO.dao.ItemDAO;

public class Menu {
    
    private static final int ADD_NEW_ITEM = 1;
    private static final int DELETE_ITEM = 2;
    private static final int EDIT_ITEM = 3;
	
	public static void start(){
		
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ItemDAO itemDao = (ItemDAO) context.getBean("itemImpl");
        int choice;
		Scanner sc = new Scanner(System.in);
        
        do {
		    System.out.println("\n\t------ Apple Store ------");
		    Input.printItems(itemDao);
		    System.out.println("[1] Add New Item");
		    System.out.println("[2] Delete Item");
		    System.out.println("[3] Edit Item");
		    System.out.println("[4] View Item by Id");
		    System.out.println("[0] Exit");
		    System.out.print("--> ");
		    choice = checkIntInput(sc);
			
			switch(choice){
				
			case ADD_NEW_ITEM:
				Input.addItem(itemDao);
			break;
			
			case DELETE_ITEM:
			    Input.deleteItem(itemDao);
			break;
			
			case EDIT_ITEM:
				Input.editItem(itemDao);
			break;
			
			default:
			break;
			}
		} while (choice != 0);
	}
	
     public static int checkIntInput(Scanner sc){
		
	    int choice;
	    while (!sc.hasNextInt()){
		    System.out.print("\tPlease enter a valid number --> ");
		    sc.next();
	    }
		
	    choice = sc.nextInt();
		
	    return choice;
	}
}
