package com.openclassrooms.etudiant.service;

import com.openclassrooms.etudiant.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudentData(Student student);
    Optional<Student> getStudentData(Long id);
    List<Student> getStudentsData();
    Student updateStudentData(Student student);
    void deleteStudentData(Long id);

}
