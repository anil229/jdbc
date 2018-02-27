package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
	public Connection getConnection(){
		Connection connection=null;
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			
			//step2: establish a connection with DB server                             URL			Username, pswd    
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=False","root","vardhan535");
		}catch(Exception e){
			e.printStackTrace();
		}
		return connection;
	}

}
