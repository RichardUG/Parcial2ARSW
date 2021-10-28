package edu.eci.covid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.covid"})
public class covidApp {
    public static void main(String[] args) {
        SpringApplication.run(covidApp.class, args);
    }
}
