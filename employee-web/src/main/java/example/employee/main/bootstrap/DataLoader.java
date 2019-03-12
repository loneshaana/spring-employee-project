package example.employee.main.bootstrap;

import employee.example.data.model.Company;
import employee.example.data.model.Employee;
import employee.example.data.services.CompanyService;
import employee.example.data.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CompanyService companyService;
    private final EmployeeService employeeService;

    public DataLoader(CompanyService companyService, EmployeeService employeeService) {
        this.companyService = companyService;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String ...args) throws Exception{
        Employee employee = new Employee();
        Company company = new Company();
        company.setCompanyName("Milvik Technologies");
        company.setCompanyLocation("Bengalore");

        employee.setFirstName("Anwar");
        employee.setLastName("Ul haq");

        Company savedCompany = companyService.save(company);

        employee.setCompanyId(savedCompany.getId());

        employeeService.save(employee);

        System.out.println("Loaded employees");

        Employee newEmp = new Employee();
        Company newCom = new Company();

        newCom.setCompanyLocation("Australia");
        newCom.setCompanyType("Travel");
        newCom.setCompanyName("Travel And Insurance Ltd");

        newEmp.setFirstName("Lal");
        newEmp.setLastName("Mohan");


        Company newSavedCmp = companyService.save(newCom);
        newEmp.setCompanyId(newSavedCmp.getId());
        employeeService.save(newEmp);

        System.out.println("Loaded Companies");
    }
}
