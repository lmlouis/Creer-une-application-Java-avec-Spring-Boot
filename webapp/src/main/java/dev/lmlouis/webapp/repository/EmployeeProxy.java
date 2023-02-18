package dev.lmlouis.webapp.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import dev.lmlouis.webapp.CustomProperties;
import dev.lmlouis.webapp.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmployeeProxy {

    @Autowired
    private CustomProperties props;

    /**
    * Get all employees
    * @return An iterable of all employees
    */

    public Iterable<Employee> getEmployees() {
        String baseApiUrl = props.getApiUrl();
        String getEmployeesUrl = baseApiUrl + "/employees";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Employee>> response = restTemplate.exchange(
                getEmployeesUrl,// URI API
                HttpMethod.GET, // Methode HTTP
                null, // Donnée envoyé en entête
                new ParameterizedTypeReference<Iterable<Employee>>() {} // Valeur de retour
                );

        log.debug("Get Employees call " + response.getStatusCode().toString());
        
        return response.getBody();
    }

    public Employee createEmployee(Employee e) {
        String baseApiUrl = props.getApiUrl();
        String createEmployeeUrl = baseApiUrl + "/employees";
    
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employee> request = new HttpEntity<Employee>(e);
        ResponseEntity<Employee> response = restTemplate.exchange(
            createEmployeeUrl,
            HttpMethod.POST,
            request,
            Employee.class);
    
        log.debug("Appel de methode create employee " + response.getStatusCode().toString());
    
        return response.getBody();
    }


    public Employee updateEmployee(Employee e, Long id) {
        String baseApiUrl = props.getApiUrl();
        String createEmployeeUrl = baseApiUrl + "/employees/"+id;
    
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employee> request = new HttpEntity<Employee>(e);
        ResponseEntity<Employee> response = restTemplate.exchange(
            createEmployeeUrl,
            HttpMethod.PUT,
            request,
            Employee.class);
    
        log.debug("Appel de methode create employee " + response.getStatusCode().toString());
    
        return response.getBody();
    }




    public Optional<Employee> getEmployeeById(Long id) {
        String baseApiUrl = props.getApiUrl();
        String getEmployeeByIdUrl = baseApiUrl + "/employees/"+id;
    
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Long> request = new HttpEntity<Long>(id);
        ResponseEntity<Optional<Employee>> response = restTemplate.exchange(
            getEmployeeByIdUrl,
            HttpMethod.GET,
            request,
            new ParameterizedTypeReference<Optional<Employee>>() {});
    
        log.debug("Appel de methode getEmployeeById " + response.getStatusCode().toString());
    
        return response.getBody();
    }


    public void deleteEmployee(Long id) {
        String baseApiUrl = props.getApiUrl();
        String deleteEmployeeUrl = baseApiUrl + "/employees/"+id;
    
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Long> request = new HttpEntity<Long>(id);
        ResponseEntity<Employee> response = restTemplate.exchange(
            deleteEmployeeUrl,
            HttpMethod.DELETE,
            request,
            Employee.class);
    
        log.debug("Appel de methode getEmployeeById " + response.getStatusCode().toString());
    }




}
    

