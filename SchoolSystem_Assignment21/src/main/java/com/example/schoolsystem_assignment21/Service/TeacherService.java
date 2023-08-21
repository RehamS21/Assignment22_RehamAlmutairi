package com.example.schoolsystem_assignment21.Service;

import com.example.schoolsystem_assignment21.Api.ApiException;
import com.example.schoolsystem_assignment21.Model.Address;
import com.example.schoolsystem_assignment21.Model.Teacher;
import com.example.schoolsystem_assignment21.Repository.AddressRepository;
import com.example.schoolsystem_assignment21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public void updateTeacher(Integer id, Teacher teacher){
        Teacher oldTeacher = teacherRepository.findTeacherById(id);

        if (oldTeacher ==null)
            throw new ApiException("Sorry teacher not found");

        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setSalary(teacher.getSalary());
        oldTeacher.setEmail(teacher.getEmail());

        teacherRepository.save(oldTeacher);

    }

    public void deleteTeacher(Integer id){
        Teacher deleteTeacher = teacherRepository.findTeacherById(id);

        if (deleteTeacher ==null)
            throw new ApiException("Sorry teacher not found");

        teacherRepository.delete(deleteTeacher);
    }

    public Teacher getTeacherInfo(Integer id){
        Address address = addressRepository.findAddressById(id);
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null)
            throw new ApiException("Sorry teacher not found");
        else if (address == null )
            throw new ApiException("Sorry, no address for this teacher");

        return teacher;
    }

}
