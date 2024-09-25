package com.jsp.shoppingcart_application.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingcart_application.dto.Customer;

@Repository
public class CustomerDao {
	@Autowired
	private EntityManagerFactory emf;
	
	public void saveCustomer(Customer c)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
		
	}
	
	public Customer findCustomerById(int id)
	{
		EntityManager em = emf.createEntityManager();
		Customer c = em.find(Customer.class, id);
		return c;
		
	}
	
	public void updateCustomer(Customer c)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(c);
		et.commit();
	}
	
	public void deleteCustomerById(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Customer c = em.find(Customer.class, id);
		et.begin();
		em.remove(c);
		et.commit();
	}
	public Customer findCustomerEmailAndPassword(String email, String password)
	{
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select c from Customer c where c.email=?1 and c.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			Customer c = (Customer) query.getSingleResult();
			return c;
		}
		catch(NoResultException e)
		{
			return null;
		}
		
	}

}
