package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDao = theEmployeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int theId) {

        return employeeDao.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {

        return employeeDao.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeDao.deleteById(theId);

    }
}
