package com.assignmenttwo.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudentDto {

    private long id;
    private String stdName;
    private String stdClass;
    private String stdPhone;
    private String stdEmail;
    private long stdCreatedBy;
    private LocalDateTime stdCreatedOn;
    private long stdUpdatedBy;
    private LocalDateTime stdUpdatedOn;

    private long stdCourseId;

}
