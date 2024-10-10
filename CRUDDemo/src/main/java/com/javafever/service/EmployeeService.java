package com.javafever.service;

import com.javafever.model.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee emp);
	
	public Employee findEmployee(int id);
	
	public void deleteById(int id);
	
	public Employee update(Employee emp);

}
