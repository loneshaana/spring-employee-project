package employee.example.data.services.map;

import employee.example.data.model.Employee;
import employee.example.data.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EmployeeServiceMap extends AbstractMapService<Employee,Long> implements EmployeeService {
    @Override
    public Set<Employee> getAll(){
        return super.getAll();
    }

    @Override
    public Employee findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return super.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Employee employee) {
        super.delete(employee);
    }

    @Override
    public Employee replaceAtId(Long id ,Employee employee){
        return super.replaceAtId(id,employee);
    }
}
