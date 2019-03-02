package employee.example.data.services.map;

import employee.example.data.model.Employee;
import employee.example.data.services.CompanyService;
import employee.example.data.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EmployeeServiceMap extends AbstractMapService<Employee,Long> implements EmployeeService {
    private final CompanyService companyService;

    @Autowired
    public EmployeeServiceMap(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public Set<Employee> getAll(){
        return super.getAll();
    }

    @Override
    public Employee findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return super.save(employee);
    }

    @Override
    public Employee deleteById(Long id) {
        Employee emp =  this.findById(id);
        companyService.deleteEmployee(emp.getCompanyId(),id);
        return super.deleteById(id);
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
