package com.example.studentwebservice.controllers;

import com.example.studentwebservice.models.Job;
import com.example.studentwebservice.services.JobService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api
@RestController
@RequestMapping("job")
//@PreAuthorize("hasAuthority('USER')")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping("create")
    public ResponseEntity createJob(@RequestParam String name, @RequestParam Long courseId) {
        return jobService.create(name, courseId);
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
