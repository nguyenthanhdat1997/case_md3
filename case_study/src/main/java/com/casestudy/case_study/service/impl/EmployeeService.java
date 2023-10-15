package com.casestudy.case_study.service.impl;

import com.casestudy.case_study.DAO.IEmployeeDAO;
import com.casestudy.case_study.DAO.impl.EmployeeDAO;
import com.casestudy.case_study.model.Employee;
import com.casestudy.case_study.service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeDAO.findById(id);
    }

    @Override
    public boolean add(Employee object) {
        return employeeDAO.add(object);
    }
    @Override
    public boolean update(Employee object) {
        return employeeDAO.update(object);
    }

    @Override
    public boolean remove(Long id) {
        return employeeDAO.remove(id);
    }
}
