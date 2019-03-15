package employee.example.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee  extends Person{

   @ManyToOne
   @JoinColumn
   @JsonBackReference
   private Company company;

   @Enumerated(EnumType.STRING)
   @Column(name = "employee_status")
   private Status status;

   @Column(name = "salary")
   private Long salary;

   @Column(name = "role")
   private Role role;

}
