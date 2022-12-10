package com.example.studentwebservice.services;

import com.example.studentwebservice.models.Course;
import com.example.studentwebservice.repos.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public ResponseEntity create(Course course){
        courseRepository.save(course);
        return ResponseEntity.ok()
                .body(HttpStatus.OK);
    }

    public List<Course> list(){
        return courseRepository.findAll();
    }

    public Course getCourse(Long id){
        return courseRepository.findCourseById(id);
    }
}
