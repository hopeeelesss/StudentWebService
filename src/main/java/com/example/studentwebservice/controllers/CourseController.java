package com.example.studentwebservice.controllers;

import com.example.studentwebservice.models.Course;
import com.example.studentwebservice.services.CourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api
@RestController
@RequestMapping("course")
//@PreAuthorize("hasAuthority('USER')")
public class CourseController {
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

    @PutMapping("{id}")
    public Course update(@PathVariable Long id, @RequestBody Course updatedCourse){
        return courseService.update(id, updatedCourse);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){return courseService.delete(id);}
}
