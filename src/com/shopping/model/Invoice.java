package com.shopping.model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Invoice {
	private int CustID;
	private Timestamp Date;
	private int InvID;
	private ArrayList<Item> Items;
	
	Invoice(int cust, Timestamp date, ArrayList<Item> items){
		
	}
	
	
	public void addItem(Item item) {
		Items.add(item);
	}
	
	public int getCustID() {
		return CustID;
	}
	public void setCustID(int custID) {
		CustID = custID;
	}
	public Timestamp getDate() {
		return Date;
	}
	public void setDate(Timestamp date) {
		this.Date = date;
	}
	public int getInvID() {
		return InvID;
	}
	public void setInvID(int invID) {
		InvID = invID;
	}
	public ArrayList<Item> getItems() {
		return Items;
	}
	public void setItems(ArrayList<Item> items) {
		this.Items = items;
	}
	
}
