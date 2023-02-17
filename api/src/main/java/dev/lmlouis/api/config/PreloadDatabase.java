package dev.lmlouis.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.lmlouis.api.model.Employee;
import dev.lmlouis.api.service.EmployeeService;

@Configuration
public class PreloadDatabase {
    private static final Logger log = LoggerFactory.getLogger(PreloadDatabase.class);

    @Autowired
    EmployeeService service;

    @Bean
    CommandLineRunner initDatabase() {

        return args -> {
        log.info("Initialisation... " + service.saveEmployee(new Employee(null,"Laurent", "GINA", "laurentgina@mail.com", "laurent")));
        log.info("Initialisation... " + service.saveEmployee(new Employee(null,"Sophie", "FONCEK", "sophiefoncek@mail.com", "sophie")));
        log.info("Initialisation... " + service.saveEmployee(new Employee(null,"Agathe", "FEELING", "agathefeeling@mail.com", "agathe")));
        };
    }
    
}
