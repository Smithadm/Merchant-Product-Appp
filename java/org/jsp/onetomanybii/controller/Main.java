package org.jsp.onetomanybii.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.onetomanybi.Dto.Merchant;
import org.jsp.onetomanybi.Dto.Product;
import org.jsp.onetomanybii.Dao.Merchant_dao;
import org.jsp.onetomanybii.Dao.Product_dao;

public class Main {
	static Scanner sc=new Scanner(System.in);
	static Merchant_dao mer=new Merchant_dao();
	static Product_dao pro=new Product_dao();
public static void main(String[] args) {
	System.out.println("1 save Merchant");
	System.out.println("2 update Merchant");
	System.out.println("3 verify merchant by phone and password");
	System.out.println("4 verify Merchant by email and password");
	System.out.println("5 Add product");
	System.out.println("6 update product");
	System.out.println("7 find product by merchant id");
	System.out.println("8 find product by merchant phone and pasword");
	System.out.println("9 find by brand");
	System.out.println("10 find by category");
	switch (sc.nextInt()) {
	case 1:
		savem();
		break;
		
	case 2 :
		updatem();
		break;
	case 3 :
		verifmybyphonepassword();
		break;
	case 4:
		verifymbyemailpassowrd();
		break;
		
	case 5:
		savep();
		break;
	case 6:
		updatep();
		break;
	case 7 :
		findprodbymerchid();
		break;
	case 8:
		findmercbyphonepassw();
		break;
	case 9:
		findbybrand();
		break;
	case 10:
		findbycategory();
		break;
	default:
		System.out.println("you have entered wrong id");
		break;
	}
}
public static void savem() {
	Merchant m=new Merchant();
	System.out.println("enter name , phone , email , gst, password to save record");
	m.setName(sc.next());
	m.setPhone(sc.nextLong());
	m.setEmail(sc.next());
	m.setGst(sc.next());
	m.setPassword(sc.next());
	m=mer.savem(m);
	System.out.println("record saved with id"+m.getId());
	}
public static void updatem() {
	System.out.println("enter the id to update");
	int id=sc.nextInt();
	Merchant m=new Merchant();
	m.setId(id);
	System.out.println("enter name , phone , email , gst, password to save record");
	m.setName(sc.next());
	m.setPhone(sc.nextLong());
	m.setEmail(sc.next());
	m.setGst(sc.next());
	m.setPassword(sc.next());
	m=mer.updatem(m);
	if(m!=null) {
		System.out.println("record updated with id"+m.getId());
	}
	else {
		System.out.println("you have entered wrong id");
	}
}
public static void verifmybyphonepassword() {
	System.out.println("enter phone and password to verify merchant");
	long phone=sc.nextLong();
	String password=sc.next();
Merchant	m=mer.verifmybyphonepass(phone,password);
if(m!=null) {
	System.out.println(m.getName());
	System.out.println(m.getPhone());
	System.out.println(m.getEmail());
	System.out.println(m.getGst());
	System.out.println(m.getGst());
	System.out.println(m.getPassword());
}
else {
	System.out.println("you have entered worng details");
}
}
public static void verifymbyemailpassowrd() {
	System.out.println("enter email and password to verify merchant");
	String email=sc.next();
	String password=sc.next();
	Merchant m=mer.verifymbyemailpassowrd(email,password);
		if(m!=null) {
			System.out.println(m.getName());
			System.out.println(m.getPhone());
			System.out.println(m.getEmail());
			System.out.println(m.getGst());
			System.out.println(m.getGst());
			System.out.println(m.getPassword());
		}
		else {
			System.out.println("you have entered worng details");
		}
	}
public static void savep() {
	System.out.println("enter merchant id to save product");
	int id=sc.nextInt();
	System.out.println("enter name , brand , category , description to save product");
	Product p=new Product();
	p.setName(sc.next());
	p.setBrand(sc.next());
	p.setCategory(sc.next());
	p.setDescription(sc.next());
	p=pro.savep( p ,  id);
	System.out.println("p saved with id"+p.getId());
	
}
public static void updatep() {
	System.out.println("enter product id to update");
	int id=sc.nextInt();
	System.out.println("enter name , brand , category , description to update product");
	Product p=new Product();
	p.setName(sc.next());
	p.setBrand(sc.next());
	p.setCategory(sc.next());
	p.setDescription(sc.next());
	p=pro.updatep(p,id);
	if(p!=null) {
		System.out.println("record saved with id"+p.getId());
	}
	else {
		System.out.println("wrong id");
	}
}
public static void findprodbymerchid() {
	System.out.println("enter merchant id to find product");
	int id=sc.nextInt();
List<Product>	pp =pro.findprodbymerchid(id);
if(pp.size()>0) {
	for(Product p:pp) {
		System.out.println(p.getBrand());
		System.out.println(p.getCategory());
		System.out.println(p.getDescription());
		System.out.println(p.getName());
		System.out.println(p.getId());
	}
}
}
public static void findmercbyphonepassw() {
	System.out.println("enter merchant phone and password");
	long phone =sc.nextLong();
	String password=sc.next();
	List<Product>	pp =pro.findprodbymerchid(phone , password);
	if(pp.size()>0) {
		for(Product p:pp) {
			System.out.println(p.getBrand());
			System.out.println(p.getCategory());
			System.out.println(p.getDescription());
			System.out.println(p.getName());
			System.out.println(p.getId());
		}
	}
}
public static void findbybrand() {
	System.out.println("enter brand");
	String brand=sc.next();
	List<Product>	pp=pro.findbybrand(brand);
	if(pp.size()>0) {
		for(Product p:pp) {
			System.out.println(p.getBrand());
			System.out.println(p.getCategory());
			System.out.println(p.getDescription());
			System.out.println(p.getName());
			System.out.println(p.getId());
		}
}
}
public static void findbycategory() {
	System.out.println("enter category");
	String category=sc.next();
	List<Product>	pp=pro.findbycategory(category);
	if(pp.size()>0) {
		for(Product p:pp) {
			System.out.println(p.getBrand());
			System.out.println(p.getCategory());
			System.out.println(p.getDescription());
			System.out.println(p.getName());
			System.out.println(p.getId());
		}
}
}
}

