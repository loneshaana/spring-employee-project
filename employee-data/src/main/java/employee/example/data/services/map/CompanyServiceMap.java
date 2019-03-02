package employee.example.data.services.map;

import employee.example.data.model.Company;
import employee.example.data.model.Employee;
import employee.example.data.services.CompanyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CompanyServiceMap extends AbstractMapService<Company,Long> implements CompanyService {

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
            object.setStatus(true);
            Company savedCmp = super.save(object); // save the company first ,so that its id gets generated
            object.getEmployeeSet().forEach(employee -> {
                if(employee.getCompanyId() == null){
                    employee.setCompanyId(savedCmp.getId());
                }
            });
            return savedCmp;
        }else{
            throw new Error("Object Is Required");
        }
    }

    @Override
    public Company deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    public void delete(Company object) {
        super.delete(object); //complete remove
    }

    @Override
    public Company replaceAtId(Long aLong, Company object) {
        return null;
    }

    @Override
    public Boolean deleteEmployee(Long companyId,Long empId){
        Company foundCompany = this.findById(companyId);
        Set<Employee> foundEmployeeSet = foundCompany.getEmployeeSet();

        foundEmployeeSet.forEach(employee -> {
            if(employee.getId().equals(empId)){
                employee.setStatus(false); // Always save the record , internally only change their status
//                 foundEmployeeSet.remove(employee);
            }
        });

        return true;
    }

}
