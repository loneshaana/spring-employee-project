package employee.example.data.services.JpaImpl;

import employee.example.data.commands.EmployeeCommand;
import employee.example.data.converters.EmployeeToEmployeeCommand;
import employee.example.data.model.Company;
import employee.example.data.model.Employee;
import employee.example.data.model.Result;
import employee.example.data.repositories.EmployeeRepository;
import employee.example.data.services.EmployeeService;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springjpa")
public class EmployeeJpaImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeToEmployeeCommand employeeToEmployeeCommand;

    public EmployeeJpaImpl(EmployeeRepository employeeRepository,EmployeeToEmployeeCommand employeeToEmployeeCommand) {
        this.employeeRepository = employeeRepository;
        this.employeeToEmployeeCommand = employeeToEmployeeCommand;
    }

    @Override
    public Set<EmployeeCommand> findAll() {
        System.out.println("Employee FindAll using jpa");
        Set<EmployeeCommand> employees = new HashSet<>();
        employeeRepository.findAll().forEach(employee ->employees.add(employeeToEmployeeCommand.convert(employee)));
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
    public Result deleteById(Long aLong) {
        Result result = new Result(false);
        try{
            employeeRepository.deleteById(aLong);
            result.setResult(true);
        }catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            result.setResult(false);
        }
        return result;
    }

    @Override
    public void delete(Employee object) {
        employeeRepository.delete(object);
    }

    @Override
    public Employee replaceAtId(Long aLong, Employee object) {
        return null;
    }

    @Override
    public Company leaveCompany(Long empId) {
        try {
            Optional<Employee> foundEmp =  employeeRepository.findById(empId);
            if(foundEmp.isPresent()){
                Company companyToRemove = foundEmp.get().getCompany();
                companyToRemove.getEmployeeSet().removeIf(employee -> employee.getId().equals(empId));
                foundEmp.get().setCompany(null);
                employeeRepository.save(foundEmp.get());
                return companyToRemove;
            }else {
                throw new Error("Employee is Not present");
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
