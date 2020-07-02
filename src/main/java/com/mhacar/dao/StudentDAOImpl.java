package com.mhacar.dao;

import com.mhacar.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public List<Student> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Student> theQuery =
                currentSession.createQuery("from Student", Student.class);

        List<Student> students =  theQuery.getResultList();

        return students;
    }

    @Override
    public void addStudent(Student student) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(student);
    }

}
