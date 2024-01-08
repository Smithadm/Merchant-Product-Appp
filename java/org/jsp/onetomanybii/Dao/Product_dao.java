package org.jsp.onetomanybii.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.Dto.Merchant;
import org.jsp.onetomanybi.Dto.Product;

public class Product_dao {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction t=manager.getTransaction();
	public Product savep(Product p , int id) {
		Merchant m=manager.find(Merchant.class, id);
		if(m!=null) {
			m.getProducts().add(p);
			p.setMerchants(m);
			manager.persist(p);
			t.begin();
			t.commit();
			return p;
		}
		return null;
	}
	public Product updatep(Product p , int id) {
		Product p1=manager.find(Product.class, id);
		if(p1!=null) {
			p1.setName(p.getName());
			p1.setBrand(p.getBrand());
			p1.setCategory(p.getCategory());
			p1.setDescription(p.getDescription());
			t.begin();
			t.commit();
			return p1;
		}
		return null;
		
	}
	public List<Product> findprodbymerchid(int id){
	Query q	=manager.createQuery("select p from Product p where p.merchants.id=?1");
	q.setParameter(1, id);
	return q.getResultList();
	}
	public List<Product> findprodbymerchid(long phone , String password){
		Query q	=manager.createQuery("select p from Product p where p.merchants.phone=?1 and p.merchants.password=?2 ");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		return q.getResultList();
		}
	public List<Product> findbybrand(String brand){
	Query q	=manager.createQuery("select p from Product p where p.brand=?1");
	q.setParameter(1, brand);
	return q.getResultList();
	}
	public List<Product> findbycategory(String category){
		Query q	=manager.createQuery("select p from Product p where p.category=?1");
		q.setParameter(1, category);
		return q.getResultList();
		}
	
}
