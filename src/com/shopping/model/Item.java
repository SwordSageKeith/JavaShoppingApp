package com.shopping.model;

public class Item {
	private String ItemCode;
	private String ItemName;
	private double Price;
	private int invoiceID;
	
	public Item (String code, String name, double price){
		ItemCode = code;
		ItemName = name;
		Price = price;
	}
	
	public String getItemCode() {
		return ItemCode;
	}
	public void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}

	public int getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}
	
}
