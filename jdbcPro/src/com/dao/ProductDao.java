package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vo.Product;

public class ProductDao extends BaseDao implements IProductDao {

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		try{
		
		Connection connection=getConnection();
		String insertQuery="insert into test.product(Product_id,Product_name,Product_price,Product_descrip)"
				+ "values(?,?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
		preparedStatement.setInt(1, product.getId());
		preparedStatement.setString(2, product.getName());
		preparedStatement.setFloat(3, product.getPrice());
		preparedStatement.setString(4, product.getDescription());
		
		int i=preparedStatement.executeUpdate();
		if(i==1){
			System.out.println("Record added successfully");
		}
		preparedStatement.close();
		connection.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
	@Override
	public Product getProductById(int id) {
		
		Product product=null;
		try{
			Connection connection=getConnection();
			
			String query="select *from test.product where product_id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()){
				product=new Product();
				product.setId(resultSet.getInt("product_id"));
				product.setName(resultSet.getString("product_name"));
				product.setPrice(resultSet.getFloat("product_price"));
				product.setDescription(resultSet.getString("product_descrip"));
				
			}
			
			}catch(Exception e){
				e.printStackTrace();
			}
			return product;
	}

	@Override
	public List<Product> getProducts() {
		
		ArrayList<Product> productsList= new ArrayList<Product>();
		try{
		Connection connection=getConnection();
		
		String query="select *from test.product";
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(query);
		
		while(resultSet.next()){
			Product product=new Product();
			product.setId(resultSet.getInt("product_id"));
			product.setName(resultSet.getString("product_name"));
			product.setPrice(resultSet.getFloat("product_price"));
			product.setDescription(resultSet.getString("product_descrip"));
			
			productsList.add(product);
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return productsList;
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}
}
