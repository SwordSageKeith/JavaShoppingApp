package com.shopping.model;

import java.util.ArrayList;

public class User {
	private String UserName;
	private String Email;
	private int UserID;
	private String Password;
	private ArrayList<Item> Cart;
	private ArrayList<Item> OwnedItems;
	
	User(String name, String email, String password){
		UserName = name;
		Email = email;
		Password = password;
	}
	
	public void AddItemToCart(Item item) {
		Cart.add(item);
	}
	public void RemoveItemFromCart(int index) {
		Cart.remove(index);
	}
	
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public ArrayList<Item> getCart() {
		return Cart;
	}
	public void setCart(ArrayList<Item> cart) {
		Cart = cart;
	}
	public ArrayList<Item> getOwnedItems() {
		return OwnedItems;
	}
	public void setOwnedItems(ArrayList<Item> ownedItems) {
		OwnedItems = ownedItems;
	}
	
}
