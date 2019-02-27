package com.m3.training.inventory;
import java.sql.Connection;

public class Item {
	
	private int ID; 
	private String itemName; 
	private Integer quantity;
	
	public Item() {
		super(); 
	}
	
	public Item(String itemName, Integer quantity) {
		this.itemName = itemName; 
		this.quantity = quantity; 
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void addItem(String itemName, Integer quantiyu) {
		
	}
		
}
