package dev.lmlouis.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.servlet.ModelAndView;

import dev.lmlouis.webapp.model.Employee;
import dev.lmlouis.webapp.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService service;
    
    @GetMapping("/")
    public String home(Model model) {
        Iterable<Employee> listEmployee = service.getEmployees();
        model.addAttribute("employees", listEmployee);
        
        return "home";
    }

    // @GetMapping("/deleteEmployee/{id}")
    // public ModelAndView deleteEmployee(@PathVariable("id") final int id) {
    //     service.deleteEmployee(id);
    //     return new ModelAndView("redirect:/");
    // }

}
