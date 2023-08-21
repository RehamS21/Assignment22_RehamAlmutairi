package com.example.schoolsystem_assignment21.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private Integer id;
    @NotEmpty(message = "area must not empty")
    @Size(min = 3 , max = 30 , message = "Your area must between 3 to 30 of length")
    @Column(columnDefinition = "varchar(30) not null")
    private String area;
    @NotEmpty(message = "street must not empty")
    @Size(min = 3 , max = 30 , message = "Your street must between 3 to 30 of length")
    @Column(columnDefinition = "varchar(30) not null")
    private String street;

    @NotEmpty(message = "building number must not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String buildingNumber;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
