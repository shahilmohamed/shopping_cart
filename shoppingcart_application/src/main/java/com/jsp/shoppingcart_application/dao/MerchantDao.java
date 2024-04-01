package com.jsp.shoppingcart_application.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart_application.dto.Merchant;

@Repository
public class MerchantDao {
	@Autowired
	private EntityManagerFactory emf;
	
	public void saveMerchant(Merchant c)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
		
	}
	
	public Merchant findMerchantById(int id)
	{
		EntityManager em = emf.createEntityManager();
		Merchant c = em.find(Merchant.class, id);
		return c;
		
	}
	
	public void updateMerchant(Merchant c)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(c);
		et.commit();
	}
	
	public void deleteMerchantById(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Merchant c = em.find(Merchant.class, id);
		et.begin();
		em.remove(c);
		et.commit();
	}
	public Merchant findMerchantEmailAndPassword(String email, String password)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select c from Merchant c where c.email=?1 and c.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			Merchant c = (Merchant) query.getSingleResult();
			return c;
		}
		catch(NoResultException e)
		{
			return null;
		}
		
	}

}
