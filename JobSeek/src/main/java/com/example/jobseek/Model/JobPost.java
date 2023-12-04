package com.example.jobseek.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(columnDefinition = "varchar(80) not null")
    private  String title;
    @Column(columnDefinition = "varchar(70) not null")
    private  String description;
    @Column(columnDefinition = "varchar(90) not null")
    private String location;
    @Positive
    @NotNull
    private  Integer salary;
    private DateFormat postingDate;
}
