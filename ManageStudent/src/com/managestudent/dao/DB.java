package com.managestudent.dao;

import java.sql.*;

public class DB {
public static Connection getCon(){
	Connection con=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/elibrary?characterEncoding=UTF-8","root","12345678");
		
	}catch(Exception e){System.out.println(e);}
	return con;
}
}
