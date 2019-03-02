package example.employee.main.controllers;

import employee.example.data.model.Company;
import employee.example.data.services.CompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/get")
    public Set<Company> getAllCompanies(){
        return companyService.getAll();
    }
}
