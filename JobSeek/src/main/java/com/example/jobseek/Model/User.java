package com.example.jobseek.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    @Column(columnDefinition = "varchar(50) not null")
    private String name;
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @Column(columnDefinition = "varchar(50) not null")
    private String password;
    @Column(columnDefinition = "int(45) not null ")
    private  Integer age;
    @Column(columnDefinition = "varchar(255) not null check(role ='JOB_SEEKER' or role ='EMPLOYER')")
    private String role;
}
