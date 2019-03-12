package example.employee.main.controllers;

import employee.example.data.model.Company;
import employee.example.data.services.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/get")
    public Set<Company> getAll(){
        System.out.println("GET ALL COMPANIES");
        return companyService.findAll();
    }

    @GetMapping("/get/{id}")
    public Company getAllCompanies(@PathVariable Long id){
        return companyService.findById(id);
    }


//    @DeleteMapping("/delete/{id}")
//    public Company deleteById(@PathVariable Long id){
//        return companyService.deleteById(id);
//    }
}
