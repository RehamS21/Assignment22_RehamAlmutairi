package com.example.schoolsystem_assignment21.Repository;

import com.example.schoolsystem_assignment21.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher , Integer> {

    Teacher findTeacherById(Integer id);

    void deleteTeacherById(Integer id);
}
