package employee.example.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee  extends Person{

   @OneToMany
   private Company company;

   @Column(name = "company_id")
   private Long companyId;

   @Enumerated(EnumType.STRING)
   @Column(name = "employee_status")
   private Status status;

}
