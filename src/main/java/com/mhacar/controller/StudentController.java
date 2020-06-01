package com.mhacar.controller;

import com.mhacar.entity.Student;
//import com.mhacar.repository.StudentRepository;
import com.mhacar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

//    private StudentRepository studentRepository;

    @GetMapping("/list")
    public String listStudents(Model theModel) {

        // get customers from the dao
        List<Student> theStudents = studentService.findAll();

        // add the customers to the model
        theModel.addAttribute("students", theStudents);

        return "/list-students.xhtml";
    }

}
