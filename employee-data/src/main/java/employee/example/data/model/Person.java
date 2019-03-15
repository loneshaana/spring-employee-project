package employee.example.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
public class Person extends BaseEntity{
    private String firstName;
    private String lastName;
    private String address;
    private String city;
}
