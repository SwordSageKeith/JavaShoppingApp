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
	}
	
	public void newUser(User user) {
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
		
		
		return -1;
	}
	
	
	
	
	private void makeStore() {
		Item a = new Item("frvg1", "Apple", 1.50);
		store.add(a);
		a = new Item("frvg2", "Pear", 1.25);
		store.add(a);
	}
	
}
