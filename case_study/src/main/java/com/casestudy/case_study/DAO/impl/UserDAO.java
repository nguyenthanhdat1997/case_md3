package com.casestudy.case_study.DAO.impl;

import com.casestudy.case_study.DAO.IUserDAO;
import com.casestudy.case_study.model.User;
import com.casestudy.case_study.utils.JDBCConnection;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private final String SELECT_ALL_USER = "select * from users where is_delete = 0";
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String user_name = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                users.add(new User(id,user_name,password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public boolean save(User object) {
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
