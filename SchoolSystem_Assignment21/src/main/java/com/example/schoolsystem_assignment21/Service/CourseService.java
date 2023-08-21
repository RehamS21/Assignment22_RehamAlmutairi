package com.example.schoolsystem_assignment21.Service;

import com.example.schoolsystem_assignment21.Api.ApiException;
import com.example.schoolsystem_assignment21.Model.Address;
import com.example.schoolsystem_assignment21.Model.Course;
import com.example.schoolsystem_assignment21.Model.Teacher;
import com.example.schoolsystem_assignment21.Repository.CourseRepository;
import com.example.schoolsystem_assignment21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }
    public void addCourse(Integer teacher_id, Course course){
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);

        if(teacher == null)
            throw new ApiException("Sorry can't assign the teacher to the course");


        course.setTeacher(teacher);
        courseRepository.save(course);
    }
    public void updateCourse(Integer id, Course course){
        Course oldCourse = courseRepository.findCourseById(id);

        if (oldCourse ==null)
            throw new ApiException("Sorry course not found");

        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }


    public void deleteCourse(Integer id){
        Course deleteCourse = courseRepository.findCourseById(id);

        if (deleteCourse ==null)
            throw new ApiException("Sorry course not found");

        courseRepository.delete(deleteCourse);
    }

    public String getTeacherName(Integer course_id){
        Course course = courseRepository.findCourseById(course_id);

        if (course == null)
            throw new ApiException("Sorry, the course id is wrong");

        Teacher teacher = teacherRepository.findTeacherById(course.getTeacher().getId());
        if (teacher == null)
            throw new ApiException("Sorry, no teacher for this course");

        return teacher.getName();
    }


//    public void assignTeacherToCourse(Integer teacher_id, Integer course_id){
//        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
//        Course course = courseRepository.findCourseById(course_id);
//
//        if (course == null || teacher == null)
//            throw new ApiException("Sorry , can't assign teacher to the course");
//
//        course.setTeacher(teacher);
//
//        courseRepository.save(course);
//    }
}
