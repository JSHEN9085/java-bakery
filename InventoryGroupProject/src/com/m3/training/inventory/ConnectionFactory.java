package com.m3.training.inventory;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionFactory {
    public static Connection getConnection() {
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
			return DriverManager.getConnection(url, username, password); 
			
		} catch (SQLException | IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
  
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
    }
}

