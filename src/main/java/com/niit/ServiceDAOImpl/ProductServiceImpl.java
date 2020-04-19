package com.niit.ServiceDAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.DAO.ProductDAO;
import com.niit.ServiceDAO.ProductServiceDAO;
import com.niit.model.Product;

@Service
public class ProductServiceImpl implements ProductServiceDAO{
	@Autowired
	ProductDAO productDAO;
	
	public boolean addProduct(Product product) {
		productDAO.addProduct(product);
		return false;
	}

	public boolean updateProduct(Product product) {
		productDAO.updateProduct(product);
		return true;
	}

	public boolean deleteProductById(int productid) {
		productDAO.deleteProductbyId(productid);
		return true;
	}

	public List<Product> displayProduct() {
		return productDAO.displayProduct();
	}

	public Product displayProductById(int productid) {
		return productDAO.displayProductById(productid);
	}
	

}
