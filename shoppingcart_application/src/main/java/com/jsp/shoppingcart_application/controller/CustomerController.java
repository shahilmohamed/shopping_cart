package com.jsp.shoppingcart_application.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart_application.dao.CartDao;
import com.jsp.shoppingcart_application.dao.CustomerDao;
import com.jsp.shoppingcart_application.dto.Cart;
import com.jsp.shoppingcart_application.dto.Customer;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerDao cdao;
	@Autowired
	CartDao cartDao;
	
	@RequestMapping("/addcustomer")
	public ModelAndView addCustomer()
	{
		Customer customer = new Customer();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("customerobj", customer);
		mav.setViewName("customerform");
		return mav;
	}
	
	@RequestMapping("/savecustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customerobj") Customer c)
	{
		Cart cart = new Cart();
		c.setCart(cart);
		
		cartDao.saveCart(cart);
		cdao.saveCustomer(c);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Data Saved");
		mav.setViewName("customerloginform");
		return mav;
	}
	
	@RequestMapping("/customerloginvalidation")
	public ModelAndView customerLoginValidation(ServletRequest req, HttpSession session)
	{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Customer c = cdao.findCustomerEmailAndPassword(email, password);
		if(c!=null)
		{
			ModelAndView mav = new ModelAndView();
			mav.addObject("msg","Login Successfully");
			session.setAttribute("customerinfo", c);
			mav.setViewName("customeroptions");
			
			return mav;
		}
		else 
		{
			ModelAndView mav = new ModelAndView();
			mav.addObject("msg", "Invalid Details");
			mav.setViewName("customerloginform");
			return mav;
		}
	}

}
