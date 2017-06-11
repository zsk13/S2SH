package com.ssh.service;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.ProductDao;
import com.ssh.model.Product;

@Transactional
public class ProductService {
	
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public void save(Product product)
	{
		productDao.save(product);
	}
	
}
