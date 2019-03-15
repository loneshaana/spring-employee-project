package employee.example.data.converters;

import employee.example.data.commands.CompanyCommand;
import employee.example.data.model.Company;
import employee.example.data.model.Status;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CompanyCommandToCompany implements Converter<CompanyCommand,Company> {

    @Synchronized
    @Nullable
    @Override
    public Company convert(CompanyCommand source) {
        if(source == null){
            return null;
        }
        final  Company company = new Company();
        company.setId(source.getId());
        company.setCompanyName(source.getCompanyName());
        company.setCompanyType(source.getCompanyType());
        company.setCompanyLocation(source.getCompanyLocation());
        if(source.getStatus() != null && !Status.isValid(source.getStatus())){
            throw  new Error("Illegal Status ACTIVE/INACTIVE is valid");
        }
        company.setStatus(source.getStatus());
        return company;
    }
}
