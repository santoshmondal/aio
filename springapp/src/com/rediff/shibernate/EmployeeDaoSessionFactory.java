package com.rediff.shibernate;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

public class EmployeeDaoSessionFactory {
	protected SessionFactory sessionFactory;

	public void saveEmployee(Employee e) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		SessionFactoryUtils.closeSession(session);
	}

	public void updateEmployee(Employee e) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.update(e);
		session.getTransaction().commit();
		SessionFactoryUtils.closeSession(session);
	}

	public void deleteEmployee(Employee e) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.delete(e);
		session.getTransaction().commit();
		SessionFactoryUtils.closeSession(session);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
