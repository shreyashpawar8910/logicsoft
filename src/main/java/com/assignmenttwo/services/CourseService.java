package com.assignmenttwo.services;

import com.assignmenttwo.dto.CourseDto;
import com.assignmenttwo.entity.Course;
import com.assignmenttwo.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private CourseRepository courseRepository;
    private ModelMapper modelMapper;

    CourseService(ModelMapper modelMapper, CourseRepository courseRepository){
        this.modelMapper = modelMapper;
        this.courseRepository = courseRepository;
    }

    public CourseDto saveCourse(CourseDto courseDto){
        Course course = dtoToEntity(courseDto);

        return entityToDto(courseRepository.save(course));
    }

    public List<CourseDto> getAllCourse(){

        List<Course> course = courseRepository.findAll();
        return course.stream().map(this::entityToDto).toList();
    }


    // Mapping Entity to DTO
    private CourseDto entityToDto(Course course){

        CourseDto courseDto = new CourseDto();
        courseDto.setCourseName(course.getCourseName());
        courseDto.setCourseDuration(course.getCourseDuration());
        courseDto.setCourseFees(course.getCourseFees());
        courseDto.setCourseCreatedBy(course.getCourseCreatedBy());
        courseDto.setCourseCreatedOn(course.getCourseCreatedOn());
        courseDto.setCourseUpdatedBy(course.getCourseUpdatedBy());
        courseDto.setCourseUpdatedOn(course.getCourseUpdatedOn());


        return courseDto;
    }

    // Mapping Dto to Entity
    private Course dtoToEntity(CourseDto courseDto){

        Course course = new Course();

        course.setCourseName(courseDto.getCourseName());
        course.setCourseDuration(courseDto.getCourseDuration());
        course.setCourseFees(courseDto.getCourseFees());
        course.setCourseCreatedBy(courseDto.getCourseCreatedBy());
        course.setCourseCreatedOn(courseDto.getCourseCreatedOn());
        course.setCourseUpdatedBy(courseDto.getCourseCreatedBy());
        course.setCourseUpdatedOn(courseDto.getCourseUpdatedOn());

        return course;
    }

}
