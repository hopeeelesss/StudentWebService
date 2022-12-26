package com.example.studentwebservice.models;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String courseName;

    @ManyToMany
    Set<User> users;

    @OneToMany
            (
//                    fetch = FetchType.LAZY,
//                    mappedBy = "course"
                    cascade = CascadeType.ALL
            )
    List<Job> jobs;

    public Course(String courseName) {
        this.courseName = courseName;
    }


}
