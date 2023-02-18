package dev.lmlouis.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.lmlouis.api.model.Employee;
import dev.lmlouis.api.service.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
    * methode GET (HTTP) sur l'url ..."/employees" - Visualiser les employés.
    * @return - Un Iterable objet des Employee full fille
    */
    @GetMapping("/employees")
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    /**
     * methode GET (HTTP) sur l'url ..."/employees/{id}" - Visualiser un employé.
     * @param id
     * @return - Un Optionel Oject employee
     */
    @GetMapping("/employees/{id}")
    public  Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    /**
     * methode POST (HTTP) sur l'url ..."/employees" - Ajouter un nouvel employé.
     * @param employee
     * @return - Un Ojet employee crée
     */
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    /**
     * methode PUT (HTTP) sur l'url ..."/employees/{id}" - Modifier un employé.
     * @param employee
     * @param id
     * @return - Object employee modifié 
     */
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable Long id){
        
        return employeeService.getEmployee(id)
                                .map(
                                edit_employee ->{
                                    edit_employee.setFirstName(employee.getFirstName());
                                    edit_employee.setLastName(employee.getLastName());
                                    edit_employee.setMail(employee.getMail());
                                    edit_employee.setPassword(employee.getPassword());
                                    return employeeService.saveEmployee(edit_employee);
                                })
                                .orElseGet(
                                ()->{
                                    employee.setId(id);
                                    return employeeService.saveEmployee(employee);
                                });
    }

    
    /**
     * methode DELETE (HTTP) sur l'url ..."/employees/{id}" - Supprimer un employé.
     * @param id
     */
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
}
