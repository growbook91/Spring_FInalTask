package com.project.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.cj.jdbc.Driver");  
	        con= DriverManager.getConnection("jdbc:mysql://db4free.net:3306/koreapost","koreapostuser","calmvoice153");  
	    }catch(Exception e){
	    	System.out.println(e);
	    }  
	    return con;  
	}  
}
	