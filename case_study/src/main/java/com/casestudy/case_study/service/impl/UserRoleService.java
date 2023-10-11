package com.casestudy.case_study.service.impl;

import com.casestudy.case_study.DAO.IUserRoleDAO;
import com.casestudy.case_study.DAO.impl.UserRoleDAO;
import com.casestudy.case_study.model.UserRole;
import com.casestudy.case_study.service.IUserRoleService;

import java.util.List;

public class UserRoleService implements IUserRoleService {
    private final IUserRoleDAO userRoleDAO = new UserRoleDAO();
    @Override
    public List<UserRole> findAll() {
        return userRoleDAO.findAll();
    }

    @Override
    public UserRole findById(Long id) {
        return null;
    }

    @Override
    public boolean save(UserRole object) {
        return false;
    }

    @Override
    public boolean update(UserRole object) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
