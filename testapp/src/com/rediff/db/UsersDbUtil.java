package com.rediff.db;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UsersDbUtil {
	public static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public static void insert(User obj) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();

		session.save(obj);
		
		txn.commit();
		session.close();
	}
	
	
	public static void update(User obj) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();

		session.saveOrUpdate(obj);
		
		txn.commit();
		session.close();
	}
	
	
	public static List<User> list() {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();

		Query createQuery = session.createQuery("FROM User");
		List<User> list = createQuery.list();
		
		
		txn.commit();
		session.close();
		return list;
	}
	
	
	public static void main(String[] args) {
		list();
	}
}
