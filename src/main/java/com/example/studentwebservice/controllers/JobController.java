package com.example.studentwebservice.controllers;

import com.example.studentwebservice.models.Course;
import com.example.studentwebservice.models.Job;
import com.example.studentwebservice.repos.JobRepository;
import com.example.studentwebservice.services.JobService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
@Api
@RestController
@RequestMapping("job")
@PreAuthorize("hasAuthority('USER')")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping("create")
    public ResponseEntity createJob(@RequestParam String name, @RequestParam Long courseId) {
        return jobService.create(name, courseId);
    }

    @GetMapping("list")
    public List<Job> list(){
        return jobService.list();
    }

    @GetMapping("{id}")
    public Job getCourse(@PathVariable Long id){
        return jobService.getJob(id);
    }

    @PutMapping("{id}")
    public Job update(@PathVariable Long id, @RequestBody Job updatedJob){
        return jobService.update(id, updatedJob);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return jobService.delete(id);
    }

    @PostMapping("{id}/estimate")
    public ResponseEntity setMark(@PathVariable Long id, @RequestParam Long mark){
        return jobService.setMark(id, mark);
    }

}
