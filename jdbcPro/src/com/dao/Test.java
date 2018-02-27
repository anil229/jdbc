package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import com.vo.Product;

public class Test {
public static void addProduct(){
		
		try{
			//step1 : Load JDBC Driver
			Class.forName("org.gjt.mm.mysql.Driver");
			
			//step2: establish a connection with DB server                             URL			Username, pswd    
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=False","root","vardhan535");
			
			//step3: construct a query 
			String insertQuery="insert into test.product(product_id,product_name,product_price,product_descrip)"
			+"values(1233,'iphone',43350,'mobile')";
			
			//step4: create a stmnt object to execute a query
			Statement stmnt = connection.createStatement();
			
			//step5 : Execute the query using stmnt object
			int i=stmnt.executeUpdate(insertQuery);
			
			if(i==1){
				System.out.println("Record updated successfully");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		//addProduct();
		ProductDao productDAO=new ProductDao();
//		Product product=productDAO.getProductById(4432);
//		System.out.println("product id:"+product.getId());
//		System.out.println("product Name:"+product.getName());
//		System.out.println("product price:"+product.getPrice());
//		System.out.println("product descrip:"+product.getDescription());
//		
//		Product product=new Product(4431,"sony",23345,"mobile");
//		productDAO.addProduct(product);
		List<Product> products= productDAO.getProducts();
		
		for (Product product : products) {
			System.out.println("product id:"+product.getId());
			System.out.println("product Name:"+product.getName());
			System.out.println("product price:"+product.getPrice());
			System.out.println("product descrip:"+product.getDescription());
			
			
//		}
	}

	}
}
