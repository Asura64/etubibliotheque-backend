package com.openclassrooms.etudiant.controller;

import com.openclassrooms.etudiant.dto.student.AddDTO;
import com.openclassrooms.etudiant.mapper.StudentDtoMapper;
import com.openclassrooms.etudiant.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentDtoMapper studentDtoMapper;

    @PostMapping("/api/student")
    public ResponseEntity<?> add(@Valid @RequestBody AddDTO addDTO) {
        studentService.add(studentDtoMapper.toEntity(addDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
