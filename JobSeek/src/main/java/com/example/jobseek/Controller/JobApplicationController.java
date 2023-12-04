package com.example.jobseek.Controller;

import com.example.jobseek.ApiResponse.ApiResponse;
import com.example.jobseek.Model.JobApplication;
import com.example.jobseek.Model.JobPost;
import com.example.jobseek.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ja")
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;
    @GetMapping("/get")
    public List<JobApplication> getJobApplication(){
        return jobApplicationService.getJobApplication();
    }
    @PostMapping("/add")
    public ResponseEntity addJobApplication(@RequestBody @Valid JobApplication jobApplication, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(message));
        }
        jobApplicationService.addJobApplication(jobApplication);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("added JobApplication"));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobApplication(@PathVariable Integer id){
        boolean isDelete = jobApplicationService.deleteJobApplication(id);
        if (isDelete) {
            jobApplicationService.deleteJobApplication(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("delete JobApplication "));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(" not delete "));

    }
}
