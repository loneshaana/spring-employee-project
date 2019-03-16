package example.employee.main.controllers;

import employee.example.data.commands.EmployeeCommand;
import employee.example.data.model.Company;
import employee.example.data.model.Employee;
import employee.example.data.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = {"get"})
    public Set<EmployeeCommand> index(){
        return employeeService.findAll();
    }

    @GetMapping(value = {"get/{id}"})
    public Employee getById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    // accepts json
    @PostMapping(value = {"employee"})
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping(value = {"employee/{id}"})
    public Employee replaceEmployee(@RequestBody Employee employee , @PathVariable Long id){
        return  employeeService.replaceAtId(id,employee);
    }

    @DeleteMapping(value = {"/leave/company/{id}"})
    public Company leaveCompany(@PathVariable Long id){
        return employeeService.leaveCompany(id);
    }

//    @DeleteMapping(value = {"delete/{id}"})
//    public Employee deleteEmployee(@PathVariable Long id){
//         return  employeeService.deleteById(id);
//    }

}
