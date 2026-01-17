package com.assignmenttwo.services;

import com.assignmenttwo.dto.StudentDto;
import com.assignmenttwo.entity.Course;
import com.assignmenttwo.entity.Student;
import com.assignmenttwo.repository.CourseRepository;
import com.assignmenttwo.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;
    ModelMapper modelMapper;
    CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
        this.courseRepository = courseRepository;
    }


    public StudentDto saveStudent(StudentDto studentDto){

        Student student = dtoToEntity(studentDto);

        Course course = courseRepository.findById(studentDto.getStdCourseId()).orElseThrow();
        student.setStdCourse(course);

        return entityToDto(studentRepository.save(student)) ;
    }

    public List<StudentDto> getAllStudent(){

        List<Student> studentList = studentRepository.findAll();
        return studentList.stream().map(this::entityToDto).toList();

    }



    // Mapping Entity to DTO
    public StudentDto entityToDto(Student student){
        return modelMapper.map(student, StudentDto.class);
    }

    // Mapping DTO to Entity
    public Student dtoToEntity(StudentDto studentDto){

       /* Student student = new Student();

        student.setStdCourse(null);
        student.setStdName(studentDto.getStdName());
        student.setStdClass(studentDto.getStdClass());
        student.setStdPhone(studentDto.getStdPhone());
        student.setStdEmail(studentDto.getStdEmail());
        student.setStdCreatedBy(studentDto.getStdCreatedBy());
        student.setStdUpdatedBy(studentDto.getStdUpdatedBy());*/

        return modelMapper.map(studentDto, Student.class);
    }

}
