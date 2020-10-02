package com.shopping.dao;

import java.util.ArrayList;

import com.shopping.model.*;

public class Storage {
	
	private ArrayList<User> users;
	private ArrayList<Item> store;
	private ArrayList<Invoice> invoice;
	
	public Storage(){
		users = new ArrayList<User>();
		store = new ArrayList<Item>();
		invoice = new ArrayList<Invoice>();
		makeStore();
	}
	
	public void newUser(User user) {
		user.setUserID(users.size());
		users.add(user);
	}
	public void newInvoice(Invoice in) {
		invoice.add(in);
	}
	public Boolean checkName(String username) {
		for (User user: users) {
			if (user.getUserName().equals(username))
				return true;
		}
		return false;
	}
	public int login(String name, String pass) {
		for (User user: users) {
			if (user.getUserName().equals(name)) {
				if(user.getPassword().equals(pass))
					return user.getUserID();
			return -1;
			}
		}
		
		return -2;
	}
	public Boolean checkEmail(String email) {
		for (User user: users) {
			if(user.getEmail().equals(email))
				return true;
		}
		return false;
	}
	public Boolean validPassword(String pass) {
		if (pass.length() < 6) {
			System.out.println("Password must be at least 6 characters long");
			return false;
		} else if (pass.length() >18) {
			System.out.println("Passwword cannot be more than 18 characters long");
			return false;
		}
		
		return true;
	}
	public void  addToCart(String str, int id) {
		User u = users.get(id);
		for(Item i: store) {
			if (i.getItemName().equals(str) || i.getItemCode().equals(str)) {
				u.AddItemToCart(i);
				users.set(id, u);
				System.out.println(i.getItemName() + " was added to cart");
				return;
			}
		}
		System.out.println("No item with that name or code found");
	}
	public void viewCart(int id) {
		User u = users.get(id);
		double total = 0.0;
		for(Item i: u.getCart()) {
			total += i.getPrice();
			System.out.println(i.getItemName() + "  :  " + i.getPrice());
		}
		System.out.println("Total:  " + total);
	}
	public void buyCart(int id) {
		User u = users.get(id);
		Invoice i = new Invoice(id, u.getCart());
		invoice.add(i);
		u.setOwnedItems(u.getCart());
		u.setCart(new ArrayList<Item>());
	}
	public void printInv(int id) {
		for (Invoice i: invoice) {
			if (i.getCustID() == id) {
				System.out.println("" + i.getInvID()+ ":  number of items: " + i.getItems().size() + "     Time: " + i.getDate());
			}
		}
	}
	public Boolean showInvoiceID(int id) {
		for (Invoice i: invoice) {
			if (i.getInvID()==id) {
				System.out.println("Invoice id:  " + i.getInvID());
				System.out.println("Customer id:  " + i.getCustID());
				System.out.println("Date of transaction:  " + i.getDate());
				for (Item it: i.getItems()) {
					System.out.println("Item:  " + it.getItemName() + "    Price:  " + it.getPrice());
				}
				return true;
			}
		}
		System.out.println("No Invoice with that ID");
		return false;
	}
	public void ReturnItems(int id) {
		for (int i = 0; i < invoice.size(); i++) {
			if (invoice.get(i).getInvID() == id) {
				invoice.remove(i);
				System.out.println("Items returned");
				return;
			}
		}
		System.out.println("Invalid invoice id");
	}
	
	
	public void printStore() {
		for (Item i: store) {
			System.out.println("Item name:  " + i.getItemName() + "    Item code:  " + i.getItemCode() + "        Item Price:  " + i.getPrice());
		}
	}
	private void makeStore() {
		Item a = new Item("prod1", "Apple", 1.50);
		store.add(a);
		a = new Item("prod2", "Pear", 1.25);
		store.add(a);
	}
	
}
