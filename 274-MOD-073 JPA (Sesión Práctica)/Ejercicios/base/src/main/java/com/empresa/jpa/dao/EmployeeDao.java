package com.empresa.jpa.dao;

import java.util.List;

import com.empresa.jpa.entity.Employee;

public interface EmployeeDao {
	
	public void updateEmployee(Employee employee);
	public void saveEmployee(Employee employee);
	
	public Employee getEmployeeById(long id);
	public List<Employee> getEmployees();
	public List<Employee> getEmployeesByName(String name);
	public List<Employee> getEmployeesGtSalary(double salary);
	public List<String> getEmployeeNames();
	
	
	
	public void deleteEmployee(long id);
	public void deleteEmployees(List<Employee> employees);

}
