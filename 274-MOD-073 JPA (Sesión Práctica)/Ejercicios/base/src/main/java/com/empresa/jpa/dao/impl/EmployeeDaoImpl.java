package com.empresa.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.empresa.jpa.dao.EmployeeDao;
import com.empresa.jpa.entity.Employee;
import com.empresa.jpa.util.PersistenceManager;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getEmployeesGtSalary(double salary) {
		
		EntityManager em = PersistenceManager.getInstance().createEntityManager();

		String q = "SELECT e FROM Employee e WHERE e.salary>:salary";

		TypedQuery<Employee> query = em.createQuery(q, Employee.class);
		query.setParameter("salary", salary);
		
		return query.getResultList();
	}

	@Override
	public List<String> getEmployeeNames() {
		EntityManager em = PersistenceManager.getInstance().createEntityManager();

		String q = "SELECT e.name FROM Employee e";

		TypedQuery<String> query = em.createQuery(q, String.class);

		return query.getResultList();
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {

		EntityManager em = PersistenceManager.getInstance().createEntityManager();

		TypedQuery<Employee> query = em.createNamedQuery("Employee.getEmployeesByName", Employee.class);
		query.setParameter("employeeName", name);

		return query.getResultList();

	}

	@Override
	public List<Employee> getEmployees() {
		EntityManager em = PersistenceManager.getInstance().createEntityManager();

		String q = "SELECT e FROM Employee e";

		TypedQuery<Employee> query = em.createQuery(q, Employee.class);

		return query.getResultList();
	}

	@Override
	public Employee getEmployeeById(long id) {
		EntityManager em = PersistenceManager.getInstance().createEntityManager();
		return em.find(Employee.class, id);
	}

	@Override
	public void saveEmployee(Employee employee) {

		EntityManager em = PersistenceManager.getInstance().createEntityManager();
		try {

			em.getTransaction().begin();
			em.persist(employee);

			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public void updateEmployee(Employee employee) {

		EntityManager em = PersistenceManager.getInstance().createEntityManager();
		try {

			em.getTransaction().begin();
			em.merge(employee);

			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public void deleteEmployee(long id) {

		EntityManager em = PersistenceManager.getInstance().createEntityManager();
		try {

			em.getTransaction().begin();

			Employee employee = em.getReference(Employee.class, id);
			em.remove(employee);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public void deleteEmployees(List<Employee> employees) {

		for (Employee employee : employees) {
			deleteEmployee(employee.getId());
		}
	}

}
