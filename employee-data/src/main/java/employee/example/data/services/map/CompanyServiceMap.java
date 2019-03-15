package employee.example.data.services.map;

import employee.example.data.commands.CompanyCommand;
import employee.example.data.converters.CompanyToCompanyCommand;
import employee.example.data.model.Company;
import employee.example.data.model.Result;
import employee.example.data.model.Status;
import employee.example.data.services.CompanyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springmap")
public class CompanyServiceMap extends AbstractMapService<Company,Long> implements CompanyService {

    private final CompanyToCompanyCommand companyToCompanyCommand;

    public CompanyServiceMap(CompanyToCompanyCommand companyToCompanyCommand) {
        this.companyToCompanyCommand = companyToCompanyCommand;
    }

    @Override
    public Set<CompanyCommand> findAll() {
        Set<CompanyCommand> companyCommands = new HashSet<>();
        super.dataMap.values().forEach(company -> companyCommands.add(companyToCompanyCommand.convert(company)));
        return companyCommands;
    }

    @Override
    public Company findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Company save(Company object) {
        if(object != null){
            object.setStatus(Status.ACTIVE);
            Company savedCmp = super.save(object); // save the company first ,so that its id gets generated
//            object.getEmployeeSet().forEach(employee -> {
//                if(employee.getCompanyId() == null){
//                    employee.setCompanyId(savedCmp.getId());
//                }
//            });
            return savedCmp;
        }else{
            throw new Error("Object Is Required");
        }
    }

    @Override
    public Result deleteById(Long id) {

        super.deleteById(id);
        return new Result(true);
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
    public Result fireEmployee(Long companyId,Long empId){
//        Company foundCompany = this.findById(companyId);
//        Set<Employee> foundEmployeeSet = foundCompany.getEmployeeSet();

//        foundEmployeeSet.forEach(employee -> {
//            if(employee.getId().equals(empId)){
//                employee.setStatus(Status.INACTIVE); // Always save the record , internally only change their status
////                 foundEmployeeSet.remove(employee);
//            }
//        });

        return new Result(false);
    }

    @Override
    public CompanyCommand saveCompanyCommand(CompanyCommand companyCommand) {
        return null;
    }
}
