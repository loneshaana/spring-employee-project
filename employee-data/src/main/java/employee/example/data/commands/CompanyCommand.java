package employee.example.data.commands;

import employee.example.data.model.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CompanyCommand {
    private Long id;
    private String companyName;
    private String companyLocation;
    private String companyType;
    private Status status;
}
