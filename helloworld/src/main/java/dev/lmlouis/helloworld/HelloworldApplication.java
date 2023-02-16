package dev.lmlouis.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.lmlouis.helloworld.model.HelloWorld;
import dev.lmlouis.helloworld.service.BusinessService;

@SpringBootApplication
public class HelloworldApplication implements CommandLineRunner{
    @Autowired
	BusinessService bs ;

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		HelloWorld hw = bs.getHelloWorld();
		System.out.println(hw);
		
	}

}
