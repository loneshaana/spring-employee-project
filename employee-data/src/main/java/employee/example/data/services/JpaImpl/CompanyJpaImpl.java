package employee.example.data.services.JpaImpl;

import employee.example.data.commands.CompanyCommand;
import employee.example.data.converters.CompanyCommandToCompany;
import employee.example.data.converters.CompanyToCompanyCommand;
import employee.example.data.model.Company;
import employee.example.data.model.Employee;
import employee.example.data.model.Result;
import employee.example.data.repositories.CompanyRepository;
import employee.example.data.services.CompanyService;
import employee.example.data.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springjpa")
public class CompanyJpaImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final EmployeeService employeeService;
    private final CompanyCommandToCompany companyCommandToCompany;
    private final CompanyToCompanyCommand companyToCompanyCommand;

    @Autowired
    public CompanyJpaImpl(CompanyRepository companyRepository,CompanyCommandToCompany companyCommandToCompany,CompanyToCompanyCommand companyToCompanyCommand,EmployeeService employeeService) {
        this.companyRepository = companyRepository;
        this.companyCommandToCompany = companyCommandToCompany;
        this.companyToCompanyCommand = companyToCompanyCommand;
        this.employeeService = employeeService;
    }

    @Override
    public Result fireEmployee(Long companyId, Long empId) {
        try{
            Company gotCompany = this.findById(companyId);
            Set<Employee> employees = gotCompany.getEmployeeSet();
            Optional<Employee> employeeToDelete = employees.stream().filter(employee -> employee.getId().equals(empId)).findFirst();
            if(employeeToDelete.isPresent()){
                return employeeService.deleteById(employeeToDelete.get().getId());
            }
        }catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
        }
        return  new Result(false);
    }

    @Override
    public Set<CompanyCommand> findAll() {
        System.out.println("Company FindAll using jpa");
        Set<CompanyCommand> companies = new HashSet<>();
        companyRepository.findAll().forEach(company -> {companies.add(companyToCompanyCommand.convert(company));});
        return companies;
    }

    @Override
    public Company findById(Long aLong) {
        return companyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Company save(Company object) {
        return companyRepository.save(object);
    }

    @Override
    public  Result deleteById(Long aLong) {
        Result result = new Result();

        try{
            companyRepository.deleteById(aLong);
            result.setResult(true);
        }catch(EmptyResultDataAccessException ex){
            System.out.println("EmptyResultDataAccessException");
            result.setResult(false);
        }
        return result;
    }

    @Override
    public void delete(Company object) {

    }

    @Override
    public CompanyCommand saveCompanyCommand(CompanyCommand companyCommand) {
        if(companyCommand.getId() != null){
            System.out.println("ID to update "+companyCommand.getId());
            Optional<Company> companyOptional =  companyRepository.findById(companyCommand.getId());

            if(companyOptional.isPresent()){
                Company company = companyOptional.get();
                companyCommand.setId(company.getId());
            }else{
                System.out.println(companyCommand.getId()+" Id Is Not Present");
            }
        }else{
            System.out.println("ID Not Given");
        }
        Company companyToSave = companyCommandToCompany.convert(companyCommand);
        Company savedCmp =  companyRepository.save(companyToSave);
        return companyToCompanyCommand.convert(savedCmp);
    }

    @Override
    public Company replaceAtId(Long aLong, Company object) {
        return null;
    }
}
