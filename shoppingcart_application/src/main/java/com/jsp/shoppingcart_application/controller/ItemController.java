package com.jsp.shoppingcart_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.shoppingcart_application.dao.ProductDao;
import com.jsp.shoppingcart_application.dto.Item;
import com.jsp.shoppingcart_application.dto.Product;

@Controller
public class ItemController {
	
	@Autowired
	ProductDao pdao;
	
	@RequestMapping("additem")
	public ModelAndView addItem(@RequestParam("id") int pid)
	{
		Product p = pdao.findProductById(pid);
		
		Item i = new Item();
		i.setBrand(p.getBrand());
		i.setCategory(p.getCategory());
		i.setPrice(p.getPrice());
		i.setPid(p.getId());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("itemform");
		return mav;
	}

}
