package example.employee.main.controllers;

import employee.example.data.commands.CompanyCommand;
import employee.example.data.model.Company;
import employee.example.data.model.Result;
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
    public Set<CompanyCommand> getAll(){
        return companyService.findAll();
    }

    @GetMapping("/get/{id}")
    public Company getAllCompanies(@PathVariable Long id){
        return companyService.findById(id);
    }

    @PostMapping("/add")
    public CompanyCommand saveOrUpdate(@ModelAttribute CompanyCommand companyCommand){
        return companyService.saveCompanyCommand(companyCommand);
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Long id){
        return companyService.deleteById(id);
    }

    @DeleteMapping("/fire/employee/{cid}/{eid}")
    public Result fireAnEmployee(@PathVariable Long cid, @PathVariable Long eid){
        return companyService.fireEmployee(cid,eid);
    }
}
