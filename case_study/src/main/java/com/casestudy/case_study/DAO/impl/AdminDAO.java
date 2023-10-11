package com.casestudy.case_study.DAO.impl;

import com.casestudy.case_study.DAO.IAdminDAO;
import com.casestudy.case_study.model.Admin;
import com.casestudy.case_study.model.Customer;
import com.casestudy.case_study.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminDAO implements IAdminDAO {
    private final String SELECT_ALL_ADMIN = "select * from admins where is_delete = 0";

    @Override
    public List<Admin> findAll() {
        List<Admin> admins = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ADMIN);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Long user_id = resultSet.getLong("user_id");
                admins.add(new Admin(id,name,user_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
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
