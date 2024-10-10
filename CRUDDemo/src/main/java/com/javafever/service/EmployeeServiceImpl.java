package com.javafever.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafever.model.Employee;
import com.javafever.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public Employee addEmployee(Employee emp) {
		return repository.save(emp);
	}

	@Override
	public Employee findEmployee(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
	}

	@Override
	public Employee update(Employee emp) {
		//find by id
		Employee dbEmployee=repository.findById(emp.getId()).orElse(null);		
		
		//set the latest employee details
		dbEmployee.setAddress(emp.getAddress());
		dbEmployee.setName(emp.getName());
		dbEmployee.setPhoneNo(emp.getPhoneNo());
		
		//save
		return repository.save(dbEmployee);
	}
	
	
	

}
