package code.logic.tamil.ems_backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table( name = "employees" )

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name= "first_name")
    private String firstname;
    @Column(name= "last_name")
    private String Lastname;
    @Column(name= "email", nullable = false, unique = true)
    private String email;

}
