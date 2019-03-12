package employee.example.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee  extends Person{
   @ManyToOne
   @JoinTable(name = "company_employee",joinColumns = @JoinColumn(name = "employee_id"),inverseJoinColumns = @JoinColumn(name = "company_id"))
   private Company company;

   @Column(name = "employee_company_id")
   private Long companyId;

   @Enumerated(EnumType.STRING)
   @Column(name = "employee_status")
   private Status status;

}
