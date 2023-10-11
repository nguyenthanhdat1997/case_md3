package com.casestudy.case_study.service.impl;

import com.casestudy.case_study.DAO.IDepartmentDAO;
import com.casestudy.case_study.DAO.impl.DepartmentDAO;
import com.casestudy.case_study.model.Department;
import com.casestudy.case_study.service.IDepartmentService;

import java.util.List;

public class DepartmentService implements IDepartmentService {
    IDepartmentDAO departmentDAO = new DepartmentDAO();

    @Override
    public List<Department> findAll() {
        return departmentDAO.findAll();
    }

    @Override
    public Department findById(Long id) {
        return null;
    }

    @Override
    public boolean save(Department object) {
        return false;
    }

    @Override
    public boolean update(Department object) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
