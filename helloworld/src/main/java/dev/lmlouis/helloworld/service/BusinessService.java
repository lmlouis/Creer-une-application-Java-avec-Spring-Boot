package dev.lmlouis.helloworld.service;

import org.springframework.stereotype.Component;

import dev.lmlouis.helloworld.model.HelloWorld;

@Component
public class BusinessService {

    public HelloWorld getHelloWorld(){
        return new HelloWorld();}
    
}
