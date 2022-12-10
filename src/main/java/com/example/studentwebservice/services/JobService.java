package com.example.studentwebservice.services;

import com.example.studentwebservice.models.Job;
import com.example.studentwebservice.repos.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public ResponseEntity create(Job job){
        jobRepository.save(job);
        return ResponseEntity.ok()
                .body(HttpStatus.OK);
    }

    public List<Job> list(){
        return jobRepository.findAll();
    }
}
