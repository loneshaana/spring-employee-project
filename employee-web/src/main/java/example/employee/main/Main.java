package example.employee.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan({"employee.example.data","example.employee.main","employee.example.data.repositories"})
//@ComponentScan(basePackages = {"employee.example"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
