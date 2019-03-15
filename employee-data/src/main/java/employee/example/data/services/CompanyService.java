package employee.example.data.services;

import employee.example.data.commands.CompanyCommand;
import employee.example.data.model.Company;
import employee.example.data.model.Result;

import java.util.Set;

public interface CompanyService extends CrudService<Company,Long> {
    Result fireEmployee(Long companyId, Long empId);
    CompanyCommand saveCompanyCommand(CompanyCommand companyCommand);
    Set<CompanyCommand> findAll();
}
