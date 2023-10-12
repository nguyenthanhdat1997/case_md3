package com.casestudy.case_study.DAO.impl;

import com.casestudy.case_study.DAO.IUserRoleDAO;
import com.casestudy.case_study.model.UserRole;
import com.casestudy.case_study.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRoleDAO implements IUserRoleDAO {
    private final String SELECT_ALL_USER_ROLE = "select * from user_roles where is_delete = 0";
    @Override
    public List<UserRole> findAll() {
        List<UserRole> userRoles = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USER_ROLE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long role_id = resultSet.getLong("role_id");
                Long user_id = resultSet.getLong("user_id");
                userRoles.add(new UserRole(role_id,user_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userRoles;
    }

    @Override
    public UserRole findById(Long id) {
        return null;
    }

    @Override
    public boolean add(UserRole object) {
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
