package dev.lmlouis.webapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.lmlouis.webapp.model.Employee;
import dev.lmlouis.webapp.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService service;
    
    @RequestMapping("/")
    public String home(Model model) {
        Iterable<Employee> listEmployee = service.getEmployees();
        model.addAttribute("employees", listEmployee);
        
        return "index";
    }


    @GetMapping("/detailsEmployee/{id}")
    public String getEmployee(@PathVariable("id") final Long id, Model model) {
        Optional<Employee> optional = service.getEmployeeById(id);
        Employee employee = optional.get();
        model.addAttribute("id", employee.getId());
        model.addAttribute("firstname", employee.getFirstName());
        model.addAttribute("lastname", employee.getLastName());
        model.addAttribute("email", employee.getMail());
        return "./detailsEmployee";
    } 

    @RequestMapping("/deleteEmployee/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") final Long id) {
        service.deleteEmployee(id);
        return new ModelAndView("redirect:/");
    }

    /* Enregistrer un employer */
    @GetMapping("/showformcreate")
    public String createEmployerForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "formEmployee";
    }

    @PostMapping("/saveEmployee")
    public String createEmployer(@ModelAttribute("employee") Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/";
    }

     /* Modifier un employer */

     @GetMapping("/editEmployee/{id}")
     public String createEmployer(@PathVariable("id") Long id, Model model) {
        Optional<Employee> optional = service.getEmployeeById(id);
        Employee employee = optional.get();
         model.addAttribute("employee", employee);
         return "editEmployee";
     }

     @PostMapping("/updateEmployee/{id}")
     public String updateEmployer(@ModelAttribute("employee") Employee employee,@PathVariable("id") Long id) {
        service.updateEmployee(employee);
        return "redirect:/";
     }

}
