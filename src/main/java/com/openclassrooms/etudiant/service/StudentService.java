package com.openclassrooms.etudiant.service;

import com.openclassrooms.etudiant.entities.Student;

import java.util.List;

public interface StudentService {
    Student saveStudentData(Student student);
    List<Student> getStudentsData();
    Student updateStudentData(Student student);
    void deleteStudentData(Long id);

}
