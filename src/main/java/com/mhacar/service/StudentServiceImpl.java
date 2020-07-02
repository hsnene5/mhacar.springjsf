package com.mhacar.service;

import com.mhacar.dao.StudentDAO;
import com.mhacar.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public List<Student> findAll() {

        return studentDAO.findAll();
    }

    @Override
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }
}
