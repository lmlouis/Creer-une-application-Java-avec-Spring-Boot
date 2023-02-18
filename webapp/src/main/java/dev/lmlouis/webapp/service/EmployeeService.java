package dev.lmlouis.webapp.service;

import dev.lmlouis.webapp.model.Employee;
import dev.lmlouis.webapp.repository.EmployeeProxy;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;

@Data
@Service
public class EmployeeService {

    @Autowired
    private EmployeeProxy employeeProxy;

    public Optional<Employee> getEmployeeById(final Long id) {
        return employeeProxy.getEmployeeById(id);
    }

    public Iterable<Employee> getEmployees() {
        return employeeProxy.getEmployees();
    }

    public void deleteEmployee(final Long id) {
        employeeProxy.deleteEmployee(id);
    }

     public Employee saveEmployee(Employee employee) {
        Employee savedEmployee;

        // Règle de gestion : Le nom de famille doit être mis en majuscule.
        employee.setLastName(employee.getLastName().toUpperCase());
        savedEmployee = employeeProxy.createEmployee(employee);
    
        return savedEmployee;
    }

    public Employee updateEmployee(Employee employee) {
        Employee savedEmployee;

        // Règle de gestion : Le nom de famille doit être mis en majuscule.
        employee.setLastName(employee.getLastName().toUpperCase());

        savedEmployee = employeeProxy.updateEmployee(employee, employee.getId());
    
        return savedEmployee;
    }

}