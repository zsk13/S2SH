package com.ssh.dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ssh.model.Product;

public class ProductDao extends HibernateDaoSupport{

	
	
	public void save(Product product)
	{
		this.getHibernateTemplate().save(product);
	}
}
