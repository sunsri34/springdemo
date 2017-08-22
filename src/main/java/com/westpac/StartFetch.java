package com.westpac;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
@SpringBootApplication
//@ImportResource("Spring-Customer.xml")
public class StartFetch {  
	public static void main(String[] args) {
		SpringApplication.run(StartFetch.class, args);
    }       
}            