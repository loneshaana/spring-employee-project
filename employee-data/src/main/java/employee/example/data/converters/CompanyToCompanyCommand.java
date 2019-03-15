package employee.example.data.converters;

import employee.example.data.commands.CompanyCommand;
import employee.example.data.model.Company;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CompanyToCompanyCommand implements Converter<Company, CompanyCommand> {

    @Synchronized
    @Override
    @Nullable
    public CompanyCommand convert(Company source) {
        if(source == null){
            return null;
        }
        final CompanyCommand companyCommand = new CompanyCommand();
        companyCommand.setId(source.getId());
        companyCommand.setCompanyLocation(source.getCompanyLocation());
        companyCommand.setCompanyName(source.getCompanyName());
        companyCommand.setCompanyType(source.getCompanyType());
        companyCommand.setStatus(source.getStatus());
        companyCommand.setEmployees(source.getEmployeeSet());
        return companyCommand;
    }
}
