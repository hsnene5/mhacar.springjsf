package com.mhacar.controller;

import com.mhacar.entity.Student;
import com.mhacar.service.StudentService;
//import com.mhacar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


//    private StudentRepository studentRepository;

    @GetMapping("/list")
    public String listStudents(Model theModel) {

        List<Student> theStudents = studentService.findAll();

        theModel.addAttribute("students", theStudents);

        return "/list-students.xhtml";
    }

    @GetMapping("/addStudent")
    public String showFormForAdd(@ModelAttribute("student") Student student) {

        return "add.jsp";
    }

    @PostMapping("/addedStudent")
    public String addStudent(@ModelAttribute("student") Student student) {

        studentService.addStudent(student);

        return "redirect:/list";
    }


}
