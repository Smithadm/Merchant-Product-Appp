package org.jsp.onetomanybii.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanybi.Dto.Merchant;

public class Merchant_dao {
EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
EntityTransaction t=manager.getTransaction();
public Merchant savem(Merchant m) {
	manager.persist(m);
	t.begin();
	t.commit();
	return m;
}
public Merchant updatem(Merchant m) {
Merchant m1=manager.find(Merchant.class, m.getId());
if(m1!=null) {
	m1.setName(m.getName());
	m1.setPhone(m.getPhone());
	m1.setEmail(m.getEmail());
	m1.setGst(m.getGst());
	m1.setPassword(m.getPassword());
	t.begin();
	t.commit();
	return m1;
}
return null;

}
public Merchant verifmybyphonepass(long phone , String password) {
Query q	=manager.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");
q.setParameter(1, phone);
q.setParameter(2, password);

try {
return	(Merchant) q.getSingleResult();
} catch(NoResultException e) {
	return null;
}
}
public Merchant verifymbyemailpassowrd(String email , String password) {
	Query q	=manager.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
	q.setParameter(1, email);
	q.setParameter(2, password);

	try {
	return	(Merchant) q.getSingleResult();
	} catch(NoResultException e) {
		return null;
	}
}
}
