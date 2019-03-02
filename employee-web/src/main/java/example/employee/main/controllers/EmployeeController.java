package example.employee.main.controllers;

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
    public Set<Employee> index(){
        return employeeService.getAll();
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
}
