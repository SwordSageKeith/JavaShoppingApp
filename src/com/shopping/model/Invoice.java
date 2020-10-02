package com.shopping.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Invoice {
	private static int count = 1;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	private int CustID;
	private Timestamp Time;
	private int InvID;
	private ArrayList<Item> Items;

	public Invoice(int cust, ArrayList<Item> items) {
		Time = new Timestamp(System.currentTimeMillis());
		CustID = cust;
		Items = items;
		InvID = count;
		count++;
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

	public String getDate() {
		return sdf.format(Time);
	}

	public void setDate(Timestamp date) {
		this.Time = date;
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
