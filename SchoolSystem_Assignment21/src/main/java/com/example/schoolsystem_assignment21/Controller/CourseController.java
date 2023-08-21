package com.example.schoolsystem_assignment21.Controller;

import com.example.schoolsystem_assignment21.Api.ApiResponse;
import com.example.schoolsystem_assignment21.Model.Course;
import com.example.schoolsystem_assignment21.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourses(){
        return ResponseEntity.status(200).body(courseService.getAllCourse());
    }

    @PostMapping("/add/{teacher_id}")
    public ResponseEntity addNewCourse(@PathVariable Integer teacher_id ,@RequestBody @Valid Course course){
        courseService.addCourse(teacher_id,course);
        return ResponseEntity.status(200).body(new ApiResponse("new course added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourseInfo(@PathVariable Integer id, @RequestBody @Valid Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("Course info updated successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourses(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("The course deleted successfully"));
    }

    @GetMapping("/getName/{course_id}")
    public ResponseEntity getTeachersName (@PathVariable Integer course_id){
        String teacher_name = courseService.getTeacherName(course_id);

        return ResponseEntity.status(200).body(new ApiResponse("The Teacher name : '"+teacher_name+"' ."));
    }
}
