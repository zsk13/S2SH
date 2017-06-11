package com.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.model.Product;
import com.ssh.service.ProductService;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{

	private ProductService productService;
	
	private Product product = new Product();

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Product getModel() {
		return product;
	}
	
	public String save()
	{
		productService.save(product);
		return NONE;
	}
}
