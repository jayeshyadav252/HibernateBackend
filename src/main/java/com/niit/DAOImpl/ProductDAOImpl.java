package com.niit.DAOImpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.DAO.ProductDAO;
import com.niit.model.Product;

@Repository(value="productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
		return true;
	}

	public boolean updateProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);
		return true;
	}

	public boolean deleteProductbyId(int productid) {
		Product product=new Product();
		product.setProductid(productid);
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}

	public List<Product> displayProduct() {
		return sessionFactory.getCurrentSession().createQuery("from com.niit.model.Product").list();
	}

	public Product displayProductById(int productid) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from com.niit.model.Product where productid=:productid ");
		return (Product) query.setParameter("productid", productid).getResultList().get(0);
	}
	

}
