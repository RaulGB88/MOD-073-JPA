package com.empresa.jpa;

import java.util.List;

import com.empresa.jpa.dao.EmployeeDao;
import com.empresa.jpa.dao.impl.EmployeeDaoImpl;
import com.empresa.jpa.entity.Employee;

public class App03 {

	public static void main(String[] args) {
		
		EmployeeDao dao = new EmployeeDaoImpl();
		dao.saveEmployee(new Employee("Pedro García", 2345.87));
		dao.saveEmployee(new Employee("Ana López", 2345.87));
		dao.saveEmployee(new Employee("Lucía Pérez", 2345.87));

		Employee e = dao.getEmployeeById(1);
		System.out.println(e.getName());
		
		
		List<Employee> employees = dao.getEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getName());
		}
	}
}
