package com.rediff.shibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

//session.createCriteria(MyEntity.class).list();
public class EmployeeDaoSessionFactoryTxn {
	protected SessionFactory sessionFactory;

	public void saveEmployee(Employee e) {
		sessionFactory.getCurrentSession().save(e);
	}

	public void updateEmployee(Employee e) {
		sessionFactory.getCurrentSession().update(e);
	}

	public void deleteEmployee(Employee e) {
		sessionFactory.getCurrentSession().delete(e);
	}

	public List<Employee> listAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		List<Employee> list = criteria.list();
		return list;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
