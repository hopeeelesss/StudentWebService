package com.example.studentwebservice.services;

import com.example.studentwebservice.models.Course;
import com.example.studentwebservice.models.Job;
import com.example.studentwebservice.repos.CourseRepository;
import com.example.studentwebservice.repos.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    private final CourseService courseService;

    public JobService(JobRepository jobRepository, CourseService courseService) {
        this.jobRepository = jobRepository;
        this.courseService = courseService;
    }

    public ResponseEntity create(String name, Long courseId){
        Job job = new Job(name);
        courseService.addToCourse(courseId, job);
        jobRepository.save(job);
        return ResponseEntity.ok()
                .body(HttpStatus.OK);
    }

    public List<Job> list(){
        return jobRepository.findAll();
    }

    public Job getJob(Long id){
        return jobRepository.findJobById(id);
    }

    public Job update(Long id, Job updatedJob){
        Job job = jobRepository.findJobById(id);
        if(updatedJob.getMark() != null) job.setMark(updatedJob.getMark());
        if(updatedJob.getCourse() != null) job.setCourse(updatedJob.getCourse());
        if(updatedJob.getFileReference() != null) job.setFileReference(updatedJob.getFileReference());
        if(updatedJob.getName() != null) job.setName(updatedJob.getName());
        return jobRepository.save(job);
    }

    public ResponseEntity delete(Long id){
        jobRepository.deleteById(id);
        return ResponseEntity.ok()
                .body(HttpStatus.OK);
    }
}
