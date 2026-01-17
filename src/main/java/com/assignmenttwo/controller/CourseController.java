package com.assignmenttwo.controller;


import com.assignmenttwo.dto.CourseDto;
import com.assignmenttwo.entity.Course;
import com.assignmenttwo.services.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private CourseService courseService;

    public CourseController (CourseService courseService){
        this.courseService = courseService;
    }


    @PostMapping("/save")
    public CourseDto saveCourse(@RequestBody CourseDto courseDto){
        return courseService.saveCourse(courseDto);
    }

    @GetMapping("/get-all-course")
    public List<CourseDto> getAllCourse(){
        return courseService.getAllCourse();
    }

}
