package employee.example.data.services;

import employee.example.data.commands.EmployeeCommand;
import employee.example.data.model.Employee;

import java.util.Set;

public interface EmployeeService extends CrudService<Employee,Long> {
    Set<EmployeeCommand> findAll();
}
