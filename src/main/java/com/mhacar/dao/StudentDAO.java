package com.mhacar.dao;

import com.mhacar.entity.Student;

import java.util.List;

public interface StudentDAO {
    
    public List<Student> findAll();
}
