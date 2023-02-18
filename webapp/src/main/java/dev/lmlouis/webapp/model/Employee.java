package dev.lmlouis.webapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    private Long id;

    private String firstName;

    private String lastName;

    private String mail;

    private String password;

}