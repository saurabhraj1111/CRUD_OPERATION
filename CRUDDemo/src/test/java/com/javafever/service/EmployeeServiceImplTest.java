package com.javafever.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.javafever.model.Employee;
import com.javafever.repository.EmployeeRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest
public class EmployeeServiceImplTest {
	
	@Autowired
	private EmployeeServiceImpl service;
	
	@MockBean
	private EmployeeRepository repository;
	
	@Test
	public void addEmployeeTest() {
		Employee emp=new Employee(1, "Raj","delhi",7658766);
		
		when(repository.save(emp)).thenReturn(emp);
		assertEquals(emp, service.addEmployee(emp));
	}
	
	
	@Test
	public void findEmployeeTest() {
		Employee emp=new Employee(1, "Raj","delhi",7658766);
		
		when(repository.findById(1)).thenReturn(Optional.of(emp));
		assertEquals(emp, service.findEmployee(1));
	}
	
	@Test
	public void updateTest() {
		
        //Employee dbEmployee=repository.findById(emp.getId()).orElse(null);		
		
		//set the latest employee details
		//dbEmployee.setAddress(emp.getAddress());
		//dbEmployee.setName(emp.getName());
		//dbEmployee.setPhoneNo(emp.getPhoneNo());
		
		//save
		//return repository.save(dbEmployee);
		
		Employee emp=new Employee(1, "Raj","delhi",7658766);
		
		Employee updatedEmp= emp;
		emp.setAddress("hyd");
		emp.setName("Raj");
		emp.setPhoneNo(7987987);
		
		when(repository.findById(1)).thenReturn(Optional.of(emp));
		when(repository.save(updatedEmp));
		
		assertEquals(updatedEmp, service.update(emp));
        
	}

}
