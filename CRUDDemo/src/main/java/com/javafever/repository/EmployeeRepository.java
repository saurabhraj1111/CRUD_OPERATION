package com.javafever.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javafever.model.Employee;

@Repository
public interface EmployeeRepository  extends CrudRepository<Employee, Integer>{

}
