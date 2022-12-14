package com.example.studentwebservice.services;

import com.example.studentwebservice.models.Course;
import com.example.studentwebservice.models.Job;
import com.example.studentwebservice.repos.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    public Course update(Long id, Course updatedCourse){
        Course course = courseRepository.findCourseById(id);
        if(updatedCourse.getCourseName() != null) course.setCourseName(updatedCourse.getCourseName());
        if(updatedCourse.getJobs() != null) course.setJobs(updatedCourse.getJobs());
        if(updatedCourse.getUsers() != null) course.setUsers(updatedCourse.getUsers());
        return courseRepository.save(course);
    }

    public Course addToCourse(Long id, Job job){
        Course course = courseRepository.findCourseById(id);
        List<Job> jobs = course.getJobs()!= null ? course.getJobs() : new ArrayList<>();
        jobs.add(job);
        course.setJobs(jobs);
        return courseRepository.save(course);
    }

    public ResponseEntity delete(Long id){
        courseRepository.deleteById(id);
        return ResponseEntity.ok()
                .body(HttpStatus.OK);
    }
}
