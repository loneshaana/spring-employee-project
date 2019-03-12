package employee.example.data.services.map;

import employee.example.data.model.Employee;
import employee.example.data.model.Status;
import employee.example.data.services.CompanyService;
import employee.example.data.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("springmap")
public class EmployeeServiceMap extends AbstractMapService<Employee,Long> implements EmployeeService {
    private final CompanyService companyService;

    @Autowired
    public EmployeeServiceMap(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public Set<Employee> findAll(){
        System.out.println("Accessing from map");
        return super.findAll();
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
    public void deleteById(Long id) {
        Employee emp =  this.findById(id);
        companyService.deleteEmployee(emp.getCompanyId(),id);
         super.deleteById(id);
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
