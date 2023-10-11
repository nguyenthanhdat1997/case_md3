package com.casestudy.case_study.DAO.impl;

import com.casestudy.case_study.DAO.IRoleDAO;
import com.casestudy.case_study.model.Role;
import com.casestudy.case_study.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements IRoleDAO {
    private final String SELECT_ALL_ROLE = "select * from roles where is_delete = 0";

    @Override
    public List<Role> findAll() {
        List<Role> roles = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ROLE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                roles.add(new Role(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Role findById(Long id) {
        return null;
    }

    @Override
    public boolean save(Role object) {
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
