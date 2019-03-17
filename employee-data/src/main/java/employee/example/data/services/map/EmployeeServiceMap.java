package employee.example.data.services.map;

import employee.example.data.commands.EmployeeCommand;
import employee.example.data.converters.EmployeeToEmployeeCommand;
import employee.example.data.model.Company;
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
        // employee stores the company Details;
        Company company = employee.getCompany();
        company.getEmployeeSet().add(employee);
        return super.save(employee);
    }

    @Override
    public Result deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    public void delete(Employee employee) {
        super.delete(employee);
    }

    @Override
    public Employee replaceAtId(Long id ,Employee employee){
        return super.replaceAtId(id,employee);
    }

    @Override
    public Company leaveCompany(Long empId) {
        Employee employee = super.findById(empId);
        if(employee != null){
            Company company = employee.getCompany();
            company.getEmployeeSet().removeIf(employee1 -> employee1.getId().equals(empId));
            Company companyToLeave = employee.getCompany();
            employee.setCompany(new Company());
            return companyToLeave;
        }
        return null;
    }
}
