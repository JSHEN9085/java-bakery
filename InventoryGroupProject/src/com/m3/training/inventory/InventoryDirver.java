package com.m3.training.inventory;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InventoryDirver {
		public static void main(String[] args) {
			Connection conn = null;
			Statement stmt = null;
			try {
				Path path = Paths.get("res", "connection.prop"); 
				FileInputStream fis = new FileInputStream(path.toString()); 
			       Properties p = new Properties (); 
			       p.load (fis); 
			       String dname = (String) p.get ("dname"); 
			       String url = (String) p.get ("URL"); 
			       String username = (String) p.get ("user"); 
			       String password = (String) p.get ("password"); 
			       Class.forName(dname); 
				conn = DriverManager.getConnection(url, username, password);
				stmt = conn.createStatement(); 
				System.out.println("TEST DONE");
				
				String SQL = "SELECT ID, ITEM_NAME, QTY from AJ209";
				ResultSet rs = stmt.executeQuery(SQL); 
				
	          while (rs.next()) {
	        	  System.out.println(rs.getString("ID") + rs.getString("ITEM_NAME") + rs.getString("QTY"));
	        	  
	          }
	          
	          fis.close();
	          rs.close(); 
	          conn.close(); 
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
}
