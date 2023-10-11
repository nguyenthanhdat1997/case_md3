package com.casestudy.case_study.service.impl;

import com.casestudy.case_study.DAO.IAdminDAO;
import com.casestudy.case_study.DAO.impl.AdminDAO;
import com.casestudy.case_study.model.Admin;
import com.casestudy.case_study.service.IAdminService;

import java.util.List;

public class AdminService implements IAdminService {
    IAdminDAO adminDAO = new AdminDAO();

    @Override
    public List<Admin> findAll() {
        return adminDAO.findAll();
    }

    @Override
    public Admin findById(Long id) {
        return null;
    }

    @Override
    public boolean save(Admin object) {
        return false;
    }

    @Override
    public boolean update(Admin object) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }

}
