package com.example.studentwebservice.controllers;

import com.example.studentwebservice.models.Course;
import com.example.studentwebservice.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourceController {
    @Autowired
    private CourseService courseService;

    @PostMapping("create")
    public ResponseEntity createCourse(@RequestBody Course course) {
        return courseService.create(course);
    }

    @GetMapping("list")
    public List<Course> list(){
        return courseService.list();
    }

    @GetMapping("{id}")
    public Course getCourse(@PathVariable Long id){
        return courseService.getCourse(id);
    }
}
