package com.casestudy.case_study.DAO.impl;

import com.casestudy.case_study.DAO.IEmployeeDAO;
import com.casestudy.case_study.model.Customer;
import com.casestudy.case_study.model.Employee;
import com.casestudy.case_study.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {

    private final String SELECT_ALL_EMPLOYEE = "select * from employees where is_delete = 0";

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                Date date_of_birth = resultSet.getDate("date_of_birth");
                String id_card = resultSet.getString("id_card");
                String phone_number = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                double salary = resultSet.getDouble("salary");
                Long position_id = resultSet.getLong("id");
                Long department_id = resultSet.getLong("id");
                Long education_degree_id = resultSet.getLong("id");
                employees.add(new Employee(id,name,gender,date_of_birth,id_card,phone_number,email,address,salary,position_id,department_id,education_degree_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee findById(Long id) {
        return null;
    }

    @Override
    public boolean add(Employee object) {
        return false;
    }

    @Override
    public boolean update(Employee object) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }

}
