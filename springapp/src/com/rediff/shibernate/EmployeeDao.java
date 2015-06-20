package com.rediff.shibernate;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class EmployeeDao {
	protected HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public void saveEmployee(Employee e) {
		template.save(e);
		throw new RuntimeException();
	}

	public void updateEmployee(Employee e) {
		template.update(e);
	}

	public void deleteEmployee(Employee e) {
		template.delete(e);
	}
}
