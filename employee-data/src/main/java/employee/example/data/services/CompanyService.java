package employee.example.data.services;

import employee.example.data.model.Company;

public interface CompanyService extends CrudService<Company,Long> {
    Boolean deleteEmployee(Long companyId,Long empId);
}