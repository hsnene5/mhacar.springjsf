package com.mhacar.controller;

import com.mhacar.dao.StudentDAO;
import com.mhacar.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    
    private StudentDAO studentDAO;

    @Autowired
    public StudentRestController(StudentDAO theStudentDAO){
        studentDAO = theStudentDAO;
    }

    @GetMapping("/students")
    public List<Student> findAll(){
        return studentDAO.findAll();
    }
}
