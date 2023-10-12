package com.casestudy.case_study.DAO.impl;

import com.casestudy.case_study.DAO.IDepartmentDAO;
import com.casestudy.case_study.model.Department;
import com.casestudy.case_study.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO implements IDepartmentDAO {

    private final String SELECT_ALL_DEPARTMENT = "select * from departments where is_delete = 0";
    @Override
    public List<Department> findAll() {
        List<Department> departments = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_DEPARTMENT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                departments.add(new Department(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departments;
    }

    @Override
    public Department findById(Long id) {
        return null;
    }

    @Override
    public boolean add(Department object) {
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
