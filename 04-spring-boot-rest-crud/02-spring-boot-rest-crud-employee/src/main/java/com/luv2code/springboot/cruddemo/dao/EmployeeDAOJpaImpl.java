package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    // define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee",Employee.class);

        // execute the query and get the result set
        List<Employee> employees = theQuery.getResultList();

        // return the result set
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee emp = entityManager.find(Employee.class,theId);


        return emp;
    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee emp = entityManager.merge(theEmployee);
        return emp;
    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class,theId);
        entityManager.remove(theEmployee);

    }
}
