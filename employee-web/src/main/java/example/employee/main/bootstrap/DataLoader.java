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

        Employee savedEmp = employeeService.save(employee);
        company.getEmployeeSet().add(savedEmp);

        companyService.save(company);

        Employee newEmp = new Employee();
        Company newCom = new Company();

        newCom.setCompanyLocation("Australia");
        newCom.setCompanyType("Travel");
        newCom.setCompanyName("Travel And Insurance Ltd");

        newEmp.setFirstName("Lal");
        newEmp.setLastName("Mohan");

        Employee savedEmp1 = employeeService.save(newEmp);
        newCom.getEmployeeSet().add(savedEmp1);

        companyService.save(newCom);
    }
}
