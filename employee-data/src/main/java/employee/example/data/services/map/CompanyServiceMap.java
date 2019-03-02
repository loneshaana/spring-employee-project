package employee.example.data.services.map;

import employee.example.data.model.Company;
import employee.example.data.model.Employee;
import employee.example.data.services.CompanyService;
import employee.example.data.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CompanyServiceMap extends AbstractMapService<Company,Long> implements CompanyService {
    private EmployeeService employeeService;

    public CompanyServiceMap(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Set<Company> getAll() {
        return super.getAll();
    }

    @Override
    public Company findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Company save(Company object) {
        if(object != null){
            Company savedCmp = super.save(object); // save the company first ,so that its id gets generated
            object.getEmployeeSet().forEach(employee -> {
                if(employee.getId() == null){
                    Employee savedEmp = employeeService.save(employee);
                    employee.setId(savedEmp.getId());
                    employee.setCompanyId(savedCmp.getId());
                }
            });
            return savedCmp;
        }else{
            throw new Error("Object Is Required");
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Company object) {
        super.delete(object);
    }

    @Override
    public Company replaceAtId(Long aLong, Company object) {
        return null;
    }

}
