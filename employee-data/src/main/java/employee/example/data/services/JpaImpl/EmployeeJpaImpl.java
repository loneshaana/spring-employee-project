package employee.example.data.services.JpaImpl;

import employee.example.data.model.Employee;
import employee.example.data.repositories.EmployeeRepository;
import employee.example.data.services.EmployeeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springjpa")
public class EmployeeJpaImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeJpaImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Set<Employee> findAll() {
        System.out.println("Employee FindAll using jpa");
        Set<Employee> employees = new HashSet<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    @Override
    public Employee findById(Long aLong) {
        System.out.println("EMPLOYEE SERVICE JPA");
        return employeeRepository.findById(aLong).orElse(null);
    }

    @Override
    public Employee save(Employee object) {
        return employeeRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        employeeRepository.deleteById(aLong);
    }

    @Override
    public void delete(Employee object) {
        employeeRepository.delete(object);
    }

    @Override
    public Employee replaceAtId(Long aLong, Employee object) {
        return null;
    }
}
