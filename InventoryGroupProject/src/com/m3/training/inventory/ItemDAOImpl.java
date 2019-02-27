package com.m3.training.inventory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemDAOImpl implements ItemDAO  {


//	public Set getAllItems() {
//		Connection connection = ConnectionFactory.getConnection();
//	    try {
//	        Statement stmt = connection.createStatement();
//	        ResultSet rs = stmt.executeQuery("SELECT * FROM AJ209");
//	        Set users = new HashSet();
//	        while(rs.next())
//	        {
//	            Item user = extractUserFromResultSet(rs);
//	            users.add(user);
//	        }
//	        return users;
//	    } catch (SQLException ex) {
//	        ex.printStackTrace();
//	    }
//	    return null;
//	}
	
	
	@Override
	public Item getItem(String itemName) {

	    Connection connection = ConnectionFactory.getConnection();
	        try {
	            Statement stmt = connection.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM AJ209 WHERE ITEM_NAME= '" + 
	            		 itemName + "'");
	            System.out.println(rs);
	            
	            if(rs.next())
	            {
	                Item item = new Item();
	                item.setID( rs.getInt("ID") );
	                item.setItemName( rs.getString("ITEM_NAME") );
	                item.setQuantity( rs.getInt("QTY") );
	                return item;
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    return null;
	}
	
	public Boolean insertItem(Item item) {
		Connection connection = ConnectionFactory.getConnection();
	    try {
	    	Statement stmt = connection.createStatement();
	    	ResultSet rs = stmt.executeQuery("INSERT INTO AJ209 (ITEM_NAME, QTY) VALUES ('" + 
	    	item.getItemName() + "'" + ", '" + item.getQuantity() + "')"  );
	    	return true; 
	    } catch (SQLException ex) { 
	        ex.printStackTrace();
	        return false; 
	    }
	}
	
	public String deleteItem(String itemName) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			Statement stmt = connection.createStatement();
			 int i = stmt.executeUpdate("DELETE FROM AJ209 WHERE ITEM_NAME = '" + itemName + "';");
  
		    if(i == 1) {
		    	return "Item " + itemName + "has been deleted!"; 
		    }
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "failed to delete " + itemName + "!";
	}
	
	public static void main(String[] args) {
		ItemDAOImpl itemdaoimpl = new ItemDAOImpl(); 
		Item item = itemdaoimpl.getItem("DOG"); 
		System.out.println(item.getID() + " " + item.getItemName() + " " + item.getQuantity());
		
//		Item item2 = new Item("Apple", 11); 
//		itemdaoimpl.insertItem(item2); 
		
		itemdaoimpl.deleteItem("Apple"); 
		
	}

}
