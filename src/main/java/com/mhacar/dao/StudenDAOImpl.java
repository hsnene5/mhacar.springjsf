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
public class StudenDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudenDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public List<Student> findAll() {

        // current Hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // query
        Query<Student> theQuery =
                currentSession.createQuery("from Student", Student.class);

        List<Student> students =  theQuery.getResultList();

        return students;
    }
}
