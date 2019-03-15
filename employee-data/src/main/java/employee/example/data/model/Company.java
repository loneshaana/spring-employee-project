package employee.example.data.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class Company extends BaseEntity{
    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_location")
    private String companyLocation;

    @Column(name = "company_type")
    private String companyType;

    @Enumerated(EnumType.STRING)
    @Column(name = "company_status")
    private Status status;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Employee> employeeSet = new HashSet<>();

}
