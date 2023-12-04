package com.example.jobseek.Controller;

import com.example.jobseek.ApiResponse.ApiResponse;
import com.example.jobseek.Model.JobPost;
import com.example.jobseek.Model.User;
import com.example.jobseek.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/JobPost")
public class JobPostController {
    private final JobPostService jobPostService;
    @GetMapping("/get")
    public ResponseEntity getAllJobPost(){
        return ResponseEntity.status(200).body(jobPostService.getJobPost());
    }
    @PostMapping("/add")
    public ResponseEntity addJobPost(@RequestBody @Valid JobPost jobPost, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(message));
        }
        jobPostService.addJobPost(jobPost);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("added JobPost"));
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateJobPost(@PathVariable Integer id ,@RequestBody @Valid JobPost jobPost, Errors errors){
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(message));
        }
        jobPostService.updateJobPost(id, jobPost);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Update JobPost"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobPost(@PathVariable Integer id){
        boolean isDelete =jobPostService.deleteJobPost(id);
        if (isDelete ) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Delete JobPost"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Not delete"));

    }
}
