package employee.example.data.commands;

import employee.example.data.model.Role;
import employee.example.data.model.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeCommand {
    private Long id;
    private String firstName;
    private String lastName;
    private Role role;
    private Status status;
    private Long companyId;
}
