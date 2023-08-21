package com.example.schoolsystem_assignment21.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name must not empty")
    @Size(min = 3, max = 30, message = "the length of name must between to 30")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @Positive
    @NotNull(message = "Age must not null")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @Email
    @NotEmpty(message = "The email must not empty")
    @Column(columnDefinition = "varchar(30) unique not null")
    private String email;
    @Positive
    @NotNull(message = "Salary must not null")
    @Column(columnDefinition = "double not null")
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> course;
}
