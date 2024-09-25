package com.jsp.shoppingcart_application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart_application.dao.MerchantDao;
import com.jsp.shoppingcart_application.dao.ProductDao;
import com.jsp.shoppingcart_application.dto.Merchant;
import com.jsp.shoppingcart_application.dto.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductDao dao;
	
	@Autowired
	MerchantDao mdao;
	
	@RequestMapping("/addproduct")
	public ModelAndView addProducts() {
		Product p = new Product();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("productobj", p);
		mav.setViewName("productform");
		return mav;
		
	}
	
	@RequestMapping("/saveproduct")
	public ModelAndView saveProduct(@ModelAttribute("productobj") Product p, HttpSession session)
	{
		Merchant m = (Merchant) session.getAttribute("merchantinfo");
		
		List<Product> products = m.getProducts();
		
		if(products.size()>0)
		{
			products.add(p);
			m.setProducts(products);
		}
		else
		{
			List<Product> products1 = new ArrayList<Product>();
			products1.add(p);
			m.setProducts(products1);
		}
		
		dao.saveProduct(p);
		mdao.updateMerchant(m);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Product added successfully");
		mav.setViewName("merchantoptions");
		return mav;
	}
	
	@RequestMapping("/viewproduct")
	public ModelAndView viewProduct(HttpSession session)
	{
		Merchant m = (Merchant) session.getAttribute("merchantinfo");
		Merchant merchant = mdao.findMerchantById(m.getId());
		List<Product> products = merchant.getProducts();
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("viewobj", products);
		mav.setViewName("displayproducts");
		return mav;
	}
	
	@RequestMapping("/fetchallproducts")
	public ModelAndView fetchAllDetails()
	{
		List<Product> products = dao.findAllProducts();
		ModelAndView mav = new ModelAndView();
		mav.addObject("productslist",products);
		mav.setViewName("displayallproducts");
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteProduct(@RequestParam("id") int pid, HttpSession session)
	{
		Merchant m = (Merchant) session.getAttribute("merchantinfo");
		Merchant merchant =  dao.removeProductFromMerchant(m.getId(), pid);
		mdao.updateMerchant(merchant);
		dao.deleteProductById(pid);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect://viewproduct");
		return mav;
	}

}
