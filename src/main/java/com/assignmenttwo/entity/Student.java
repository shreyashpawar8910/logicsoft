package com.assignmenttwo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String stdName;
    private String stdClass;
    private String stdPhone;
    private String stdEmail;

    private long stdCreatedBy;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime stdCreatedOn;
    private long stdUpdatedBy;

    @UpdateTimestamp
    private LocalDateTime stdUpdatedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course stdCourse;
}
