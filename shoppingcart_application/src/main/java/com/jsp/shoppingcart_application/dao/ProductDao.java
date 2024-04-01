package com.jsp.shoppingcart_application.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart_application.dto.Product;

@Repository
public class ProductDao {
	@Autowired
	private EntityManagerFactory emf;
	
	public void saveProduct(Product c)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
		
	}
	
	public Product findProductById(int id)
	{
		EntityManager em = emf.createEntityManager();
		Product c = em.find(Product.class, id);
		return c;
		
	}
	
	public void updateProduct(Product c)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(c);
		et.commit();
	}
	
	public void deleteProductById(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Product c = em.find(Product.class, id);
		et.begin();
		em.remove(c);
		et.commit();
	}
	
	public List<Product> findAllProducts()
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Product p");
		
		List<Product> product = query.getResultList();
		return product;
	}
	
	public List<Product> findProductByBrand(String brand)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Product p where brand=?1");
		query.setParameter(1, brand);
		try {
			List<Product> p = (List<Product>) query.getSingleResult();
			return p;
		}
		catch(NoResultException e)
		{
			return null;
		}
	}

}
