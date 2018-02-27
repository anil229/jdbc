package com.dao;

import java.util.List;

import com.vo.Product;

public interface IProductDao {
	public void addProduct(Product product);
	Product getProductById(int id);
	List<Product> getProducts();
	void deleteProduct(int id);
	void updateProduct(Product product);

}
