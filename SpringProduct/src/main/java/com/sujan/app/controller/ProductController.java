package com.sujan.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sujan.app.entity.Product;
import com.sujan.app.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping()
	public String index(Model model) {
		List<Product> list = service.findAll();
		model.addAttribute("product",list);
		return "/product/index";		
	}
	@GetMapping("/add")
	public String add(Model model) {
	Product product = new Product();
	model.addAttribute("product", product);
		return "/product/add";
		
	}
	
	@PostMapping()
	public String save(@ModelAttribute("product") Product product) {
       service.save(product);
       return "redirect:/product";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id")Long id, Model model) {
		model.addAttribute("product",service.findById(id));
		
		return "/product/edit";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		System.out.println("Helloooooooooooo");
		service.deleteById(id);
		return "redirect:/product";
	}
}
