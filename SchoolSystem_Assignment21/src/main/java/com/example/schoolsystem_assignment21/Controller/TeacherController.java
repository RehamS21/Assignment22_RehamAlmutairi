package com.example.schoolsystem_assignment21.Controller;

import com.example.schoolsystem_assignment21.Api.ApiResponse;
import com.example.schoolsystem_assignment21.Model.Teacher;
import com.example.schoolsystem_assignment21.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeachers(){
        return ResponseEntity.status(200).body(teacherService.getAllTeacher());
    }

    @PostMapping("/add")
    public ResponseEntity addNewTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("new teacher added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacherInfo(@PathVariable Integer id, @RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher info updated successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeachers(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("The teacher deleted successfully"));
    }

    @GetMapping("/getTeacher/{id}")
    public ResponseEntity getOneTeacher(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacherInfo(id));
    }

}
