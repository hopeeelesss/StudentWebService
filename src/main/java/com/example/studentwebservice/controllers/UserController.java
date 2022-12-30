package com.example.studentwebservice.controllers;

import com.example.studentwebservice.models.Course;
import com.example.studentwebservice.models.Job;
import com.example.studentwebservice.services.CourseService;
import com.example.studentwebservice.services.JobService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping("/acc")
public class UserController {
    @Autowired
    private JobService jobService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/job/list")
    public List<Job> getJobList(){
        return jobService.list();
    }

    @GetMapping("/job/{id}")
    public Job getJob(@PathVariable Long id){
        return jobService.getJob(id);
    }

    @GetMapping("/course/list")
    public List<Course> getCourselist(){
        return courseService.list();
    }

    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable Long id){
        return courseService.getCourse(id);
    }
}
