package com.example.jobseek.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "myUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @NotEmpty(message = "please enter name")
    @Column(columnDefinition = "varchar(50) not null")
    private String name;
    @NotEmpty(message = "please enter email ")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotEmpty(message = "please enter password")
    @Column(columnDefinition = "varchar(50) not null")
    private String password;
    @NotNull(message = "please enter age")
    @Column(columnDefinition = "int(45) not null ")
    private  Integer age;
    @NotEmpty(message = "please enter JOB_SEEKER or EMPLOYER")
    @Column(columnDefinition = "varchar(255) not null check(role ='JOB_SEEKER' or role ='EMPLOYER')")
    private String role;
}
