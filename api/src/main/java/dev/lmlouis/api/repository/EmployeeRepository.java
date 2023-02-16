package dev.lmlouis.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.lmlouis.api.model.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
