package employee.example.data.services.map;

import employee.example.data.commands.EmployeeCommand;
import employee.example.data.converters.EmployeeToEmployeeCommand;
import employee.example.data.model.Employee;
import employee.example.data.model.Result;
import employee.example.data.model.Status;
import employee.example.data.services.EmployeeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springmap")
public class EmployeeServiceMap extends AbstractMapService<Employee,Long> implements EmployeeService {
    private EmployeeToEmployeeCommand employeeToEmployeeCommand;

    public EmployeeServiceMap(EmployeeToEmployeeCommand employeeToEmployeeCommand) {
        this.employeeToEmployeeCommand = employeeToEmployeeCommand;
    }

    @Override
    public Set<EmployeeCommand> findAll() {
        Set<EmployeeCommand> employeeCommands = new HashSet<>();
        super.dataMap.values().forEach(employee -> employeeCommands.add(employeeToEmployeeCommand.convert(employee)));
        return employeeCommands;
    }

    @Override
    public Employee findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        employee.setStatus(Status.ACTIVE); // set active status on save
        return super.save(employee);
    }

    @Override
    public Result deleteById(Long id) {
        return new Result(false);
    }

    @Override
    public void delete(Employee employee) {
        // before deleting the employee remove it from the Company
        super.delete(employee);
    }

    @Override
    public Employee replaceAtId(Long id ,Employee employee){
        return super.replaceAtId(id,employee);
    }
}
