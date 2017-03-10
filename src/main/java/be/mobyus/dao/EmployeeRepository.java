package be.mobyus.dao;

import org.springframework.data.repository.CrudRepository;

import be.mobyus.model.Employee;

public interface EmployeeRepository  extends CrudRepository<Employee, Long>{

}
