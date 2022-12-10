package com.example.studentwebservice.controllers;

import com.example.studentwebservice.models.Course;
import com.example.studentwebservice.models.Job;
import com.example.studentwebservice.repos.JobRepository;
import com.example.studentwebservice.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("job")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping("create")
    public ResponseEntity createJob(@RequestBody Job job) {
        return jobService.create(job);
    }

    @GetMapping("list")
    public List<Job> list(){
        return jobService.list();
    }
}
