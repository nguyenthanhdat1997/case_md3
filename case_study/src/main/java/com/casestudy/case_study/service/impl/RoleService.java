package com.casestudy.case_study.service.impl;

import com.casestudy.case_study.DAO.IRoleDAO;
import com.casestudy.case_study.DAO.impl.RoleDAO;
import com.casestudy.case_study.model.Role;
import com.casestudy.case_study.service.IRoleService;

import java.util.List;

public class RoleService implements IRoleService {
    private final IRoleDAO roleDAO = new RoleDAO();
    @Override
    public List<Role> findAll() {
        return roleDAO.findAll();
    }

    @Override
    public Role findById(Long id) {
        return null;
    }

    @Override
    public boolean add(Role object) {
        return false;
    }

    @Override
    public boolean update(Role object) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
