package employee.example.data.services.JpaImpl;

import employee.example.data.commands.CompanyCommand;
import employee.example.data.converters.CompanyCommandToCompany;
import employee.example.data.converters.CompanyToCompanyCommand;
import employee.example.data.model.Company;
import employee.example.data.model.Employee;
import employee.example.data.repositories.CompanyRepository;
import employee.example.data.repositories.EmployeeRepository;
import employee.example.data.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springjpa")
public class CompanyJpaImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyCommandToCompany companyCommandToCompany;
    private final CompanyToCompanyCommand companyToCompanyCommand;

    @Autowired
    public CompanyJpaImpl(CompanyRepository companyRepository,CompanyCommandToCompany companyCommandToCompany,CompanyToCompanyCommand companyToCompanyCommand) {
        this.companyRepository = companyRepository;
        this.companyCommandToCompany = companyCommandToCompany;
        this.companyToCompanyCommand = companyToCompanyCommand;
    }

    @Override
    public Boolean deleteEmployee(Long companyId, Long empId) {
        return null;
    }

    @Override
    public Set<Company> findAll() {
        System.out.println("Company FindAll using jpa");
        Set<Company> companies = new HashSet<>();
        companyRepository.findAll().forEach(companies::add);
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
    public void deleteById(Long aLong) {
         companyRepository.deleteById(aLong);
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
