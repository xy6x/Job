package com.example.jobseek.Service;

import com.example.jobseek.Model.JobPost;
import com.example.jobseek.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {
    private  final JobPostRepository jobPostRepository;
    public List<JobPost> getJobPost(){
        return jobPostRepository.findAll();
    }
    public void addJobPost(JobPost jobPost){
        jobPostRepository.save(jobPost);
    }
    public Boolean updateJobPost(Integer id,JobPost jobPost){
        JobPost oldJob =jobPostRepository.getById(id);
        if (oldJob == null) {
            return false;
        }
        oldJob.setTitle(jobPost.getTitle());
        oldJob.setDescription(jobPost.getDescription());
        oldJob.setLocation(jobPost.getLocation());
        oldJob.setSalary(jobPost.getSalary());
        oldJob.setPostingDate(jobPost.getPostingDate());
        jobPostRepository.save(oldJob);
        return true;
    }
    public Boolean deleteJobPost(Integer id){
        JobPost jobPost=jobPostRepository.getById(id);
        if (jobPost == null) {
            return false;
        }
        jobPostRepository.delete(jobPost);
        return true;
    }
}
