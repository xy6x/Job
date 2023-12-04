package com.example.jobseek.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(columnDefinition = "varchar(80) not null")
    private String name;
    @NotNull(message = "please enter User ID ")
    private Integer userId;
    @NotNull(message = "Please enter Post Id ")
    private Integer jobPostId;


}
