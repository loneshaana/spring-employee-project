package employee.example.data.services.map;

import employee.example.data.commands.CompanyCommand;
import employee.example.data.converters.CompanyToCompanyCommand;
import employee.example.data.model.Company;
import employee.example.data.model.Employee;
import employee.example.data.model.Result;
import employee.example.data.model.Status;
import employee.example.data.services.CompanyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
            Company savedCmp = super.save(object);
            System.out.println("Saved Object Details");
            System.out.println(savedCmp.getEmployeeSet());
            return savedCmp;
        }else{
            throw new Error("Object Is Required");
        }
    }

    @Override
    public Result deleteById(Long id) {
        return super.deleteById(id);
    }

    @Override
    public void delete(Company object) {
        super.delete(object);
    }

    @Override
    public Company replaceAtId(Long aLong, Company object) {
        return null;
    }

    @Override
    public Result fireEmployee(Long companyId,Long empId){
        Set<Employee> employeeSet = super.dataMap.get(companyId).getEmployeeSet();
        Set<Employee> newEmployeeList = new HashSet<>();
        employeeSet.forEach(employee -> {
            if(employee.getId().equals(empId)){
                employee.setCompany(new Company());
            }
            else {
                newEmployeeList.add(employee);
            }
        });
        super.dataMap.get(companyId).setEmployeeSet(newEmployeeList);
        if(newEmployeeList.size() < employeeSet.size()) return new Result(true);
//        super.dataMap.get(companyId).setEmployeeSet(employeeSet.stream().filter(employee -> !employee.getId().equals(empId)).collect(Collectors.toSet()));
//        if(super.dataMap.get(companyId).getEmployeeSet().size() < employeeSet.size()) return new Result(true);
        return  new Result(false);
    }

    @Override
    public CompanyCommand saveCompanyCommand(CompanyCommand companyCommand) {
        return null;
    }
}
