package com.openclassrooms.etudiant.controller;

import com.openclassrooms.etudiant.entities.Student;
import com.openclassrooms.etudiant.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/api/student")
    public ResponseEntity<?> saveStudentData(@Valid @RequestBody Student student) {
        try {
            return new ResponseEntity<>(studentService.saveStudentData(student), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/student")
    public ResponseEntity<?> getStudentData(@RequestParam(value = "id") Long id) {
        try {
            Optional<Student> student =  studentService.getStudentData(id);
            return student.isPresent()
                    ? new ResponseEntity<>(student, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/students")
    public ResponseEntity<List<Student>> getStudentsData() {
        try {
            return new ResponseEntity<>(studentService.getStudentsData(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("api/student")
    public ResponseEntity<?> updateStudentData(@Valid @RequestBody Student student) {
        try {
            return new ResponseEntity<>(studentService.updateStudentData(student), HttpStatus.OK);
        } catch (ObjectOptimisticLockingFailureException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("api/student")
    public ResponseEntity<?> deleteStudentData(@RequestParam(value = "id") Long id) {
        try {
            studentService.deleteStudentData(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
