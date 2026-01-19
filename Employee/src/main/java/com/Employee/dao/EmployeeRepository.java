package com.Employee.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Employee.bean.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
