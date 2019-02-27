package com.m3.training.inventory;

public interface ItemDAO {
	Item getItem(String itemName); 
	Boolean insertItem(Item item); 
}
