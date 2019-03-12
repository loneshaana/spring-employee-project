package example.employee.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"employee.example.data","example.employee.main"})
@EntityScan(basePackages = {"employee.example.data.model"})
@EnableJpaRepositories(basePackages = {"employee.example.data.repositories"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
