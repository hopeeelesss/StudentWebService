package com.example.studentwebservice.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long mark;

    @ManyToOne
//            (
//                    fetch = FetchType.LAZY,
//                    cascade = CascadeType.ALL
//            )
//    @JoinColumn(name = "jobs")
    @JsonIgnore
    private Course course;

    private String fileReference;

    public Job(String name) {
        this.name = name;
    }


}
