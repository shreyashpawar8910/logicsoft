package com.assignmenttwo.controller;


import com.assignmenttwo.dto.StudentDto;
import com.assignmenttwo.entity.Student;
import com.assignmenttwo.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public StudentDto saveStudent(@RequestBody StudentDto studentDto){
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/get-all-student")
    public List<StudentDto> getAllStudent(){
        return studentService.getAllStudent();
    }

}
