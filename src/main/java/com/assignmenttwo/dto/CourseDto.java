package com.assignmenttwo.dto;



import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CourseDto {

    private long courseId;
    private String courseName;
    private int courseDuration;
    private double courseFees;

    private long courseCreatedBy;
    private LocalDateTime courseCreatedOn;
    private long courseUpdatedBy;
    private LocalDateTime courseUpdatedOn;
    private List<Long> studentList;

}
