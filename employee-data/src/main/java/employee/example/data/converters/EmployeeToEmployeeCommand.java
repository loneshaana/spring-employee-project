package employee.example.data.converters;

import employee.example.data.commands.EmployeeCommand;
import employee.example.data.model.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeToEmployeeCommand implements Converter<Employee, EmployeeCommand> {
    @Override
    public EmployeeCommand convert(Employee source) {
        if(source == null){
            return  null;
        }

        EmployeeCommand employeeCommand = new EmployeeCommand();
        if(source.getCompany() != null && source.getCompany().getId() != null)
            employeeCommand.setCompanyId(source.getCompany().getId());
        else
            employeeCommand.setCompanyId(null);
        employeeCommand.setFirstName(source.getFirstName());
        employeeCommand.setLastName(source.getLastName());
        employeeCommand.setId(source.getId());
        employeeCommand.setRole(source.getRole());
        employeeCommand.setStatus(source.getStatus());
        return employeeCommand;
    }
}
