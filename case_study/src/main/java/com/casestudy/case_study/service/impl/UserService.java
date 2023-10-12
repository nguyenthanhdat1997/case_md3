package com.casestudy.case_study.service.impl;

import com.casestudy.case_study.DAO.IUserDAO;
import com.casestudy.case_study.DAO.impl.UserDAO;
import com.casestudy.case_study.model.User;
import com.casestudy.case_study.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private final IUserDAO userDAO = new UserDAO();
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public boolean add(User object) {
        return false;
    }
    @Override
    public boolean update(User object) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
