package com.casestudy.case_study.DAO.impl;

import com.casestudy.case_study.DAO.IEducationDegreeDAO;
import com.casestudy.case_study.model.EducationDegree;
import com.casestudy.case_study.utils.JDBCConnection;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeDAO implements IEducationDegreeDAO {
    private final String SELECT_ALL_EDUCATION_DEGREE = "select * from education_degrees where is_delete = 0";
    @Override
    public List<EducationDegree> findAll() {
        List<EducationDegree> educationDegrees = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EDUCATION_DEGREE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                educationDegrees.add(new EducationDegree(id,name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return educationDegrees;
    }

    @Override
    public EducationDegree findById(Long id) {
        return null;
    }

    @Override
    public boolean add(EducationDegree object) {
        return false;
    }

    @Override
    public boolean update(EducationDegree object) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
