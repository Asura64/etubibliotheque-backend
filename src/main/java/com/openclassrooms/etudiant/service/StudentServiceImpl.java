package com.openclassrooms.etudiant.service;

import com.openclassrooms.etudiant.entities.Student;
import com.openclassrooms.etudiant.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student saveStudentData(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudentData(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getStudentsData() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudentData(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentData(Long id) {
        studentRepository.deleteById(id);
    }
}
