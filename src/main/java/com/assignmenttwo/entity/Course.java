package com.assignmenttwo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;
    private String courseName;
    private int courseDuration;
    private double courseFees;

    private long courseCreatedBy;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime courseCreatedOn;
    private long courseUpdatedBy;

    @UpdateTimestamp
    private LocalDateTime courseUpdatedOn;

    @OneToMany(mappedBy = "stdCourse", fetch = FetchType.LAZY)
    private List<Student> studentList;
}
