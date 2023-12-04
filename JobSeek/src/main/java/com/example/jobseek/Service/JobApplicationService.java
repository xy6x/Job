package com.example.jobseek.Service;

import com.example.jobseek.Model.JobApplication;
import com.example.jobseek.Repository.JobApplicationRepository;
import com.example.jobseek.Repository.JobPostRepository;
import com.example.jobseek.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobPostRepository jobPostRepository;
    private final UserRepository userRepository;
    private final JobApplicationRepository jobApplicationRepository;

    public List<JobApplication> getJobApplication() {
        return jobApplicationRepository.findAll();
    }

    public void addJobApplication(JobApplication jobApplication) {
        for (int i = 0; i < userRepository.findAll().size(); i++) {

            if (jobApplication.getUserId() == userRepository.findAll().get(i).getId()) {
                for (int j = 0; j < jobPostRepository.findAll().size(); j++) {
                    if (jobApplication.getJobPostId() == jobPostRepository.findAll().get(i).getId()) {
                        jobApplicationRepository.save(jobApplication);

                    }
                }

            }

        }
    }
 public Boolean deleteJobApplication(Integer id){
        JobApplication jobApplication =jobApplicationRepository.getById(id);

     if (jobApplication == null) {
         return false;
     }
     jobApplicationRepository.delete(jobApplication);
     return true;
 }








}

