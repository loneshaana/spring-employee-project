package employee.example.data.services.JpaImpl;

import employee.example.data.model.Company;
import employee.example.data.repositories.CompanyRepository;
import employee.example.data.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springjpa")
public class CompanyJpaImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    @Autowired
    public CompanyJpaImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
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
        System.out.println("*************");
        System.out.println("*************");
        System.out.println("*************");
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
    public Company replaceAtId(Long aLong, Company object) {
        return null;
    }
}
