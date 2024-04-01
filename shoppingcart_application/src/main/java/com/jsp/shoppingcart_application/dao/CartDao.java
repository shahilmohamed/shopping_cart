package com.jsp.shoppingcart_application.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart_application.dto.Cart;

@Repository
public class CartDao {
	@Autowired
	private EntityManagerFactory emf;
	
	public void saveCart(Cart c)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
		
	}
	
	public Cart findCartById(int id)
	{
		EntityManager em = emf.createEntityManager();
		Cart c = em.find(Cart.class, id);
		return c;
		
	}
	
	public void updateCart(Cart c)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(c);
		et.commit();
	}
	
	public void deleteCartById(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Cart c = em.find(Cart.class, id);
		et.begin();
		em.remove(c);
		et.commit();
	}
	

}
