package com.kb.employee_service.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "Name cannot be empty")
    @NotNull(message = "Email cannot be empty")
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @NotNull(message = "Email cannot be empty")
    private String email;

    @NotEmpty(message = "Mobile number cannot be empty")
    @NotNull(message = "Email cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digits")
    private String mobileNumber;

//    @Size()
    private String designation;
    private String department;

}
