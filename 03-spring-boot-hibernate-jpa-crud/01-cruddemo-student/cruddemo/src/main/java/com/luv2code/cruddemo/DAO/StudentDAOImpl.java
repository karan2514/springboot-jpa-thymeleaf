package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {

        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String thelastName) {
    //create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student where lastName=:theData", Student.class);
        // set query parameter
        theQuery.setParameter("theData",thelastName);
        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);
        entityManager.remove(theStudent);
    }
}
