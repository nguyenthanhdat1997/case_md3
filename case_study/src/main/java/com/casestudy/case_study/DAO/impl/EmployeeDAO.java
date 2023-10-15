package com.casestudy.case_study.DAO.impl;

import com.casestudy.case_study.DAO.IEmployeeDAO;
import com.casestudy.case_study.model.Customer;
import com.casestudy.case_study.model.Employee;
import com.casestudy.case_study.utils.JDBCConnection;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {

    private final String SELECT_ALL_EMPLOYEE = "select * from employees where is_delete = 0";
    private final String SELECT_BY_ID = "select * from employees where id = ?";
    private final String INSERT = "insert into employees(name,gender,date_of_birth,id_card,phone_number,email,address,salary,position_id,department_id,education_degree_id,user_id) values(?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "update employees set name = ?, gender =?, date_of_birth = ?, id_card = ?, phone_number = ?, email = ?, address = ?, salary = ?, position_id = ?, department_id = ? ,education_degree_id = ?,user_id = ? where id = ?";
    private final String DELETE = "update employees set is_delete = 1 where id = ?";
    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String date_of_birth = resultSet.getString("date_of_birth");
                String id_card = resultSet.getString("id_card");
                String phone_number = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                double salary = resultSet.getDouble("salary");
                Long position_id = resultSet.getLong("position_id");
                Long department_id = resultSet.getLong("department_id");
                Long education_degree_id = resultSet.getLong("education_degree_id");
                Long user_id = resultSet.getLong("user_id");
                employees.add(new Employee(id, name, gender, date_of_birth, id_card, phone_number, email, address, salary, position_id, department_id, education_degree_id, user_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee findById(Long id) {
        Connection connection = JDBCConnection.getConnection();
        Employee employee = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String date_of_birth = resultSet.getString("date_of_birth");
                String id_card = resultSet.getString("id_card");
                String phone_number = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                double salary = resultSet.getDouble("salary");
                Long position_id = resultSet.getLong("position_id");
                Long department_id = resultSet.getLong("department_id");
                Long education_degree_id = resultSet.getLong("education_degree_id");
                Long user_id = resultSet.getLong("user_id");
                employee = new Employee(id, name, gender, date_of_birth, id_card, phone_number, email, address, salary, position_id, department_id, education_degree_id, user_id);
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Employee object) {
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1, object.getName());
            statement.setString(2, object.getGender());
            statement.setString(3, object.getDate_of_birth());
            statement.setString(4, object.getId_card());
            statement.setString(5, object.getPhone_number());
            statement.setString(6, object.getEmail());
            statement.setString(7, object.getAddress());
            statement.setDouble(8, object.getSalary());
            statement.setLong(9, object.getPosition_id());
            statement.setLong(10, object.getDepartment_id());
            statement.setLong(11, object.getEducation_degree_id());
            statement.setLong(12, object.getUser_id());
            int num = statement.executeUpdate();
            return num == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Employee object) {
        Connection connection = JDBCConnection.getConnection();
        boolean rowUpdate;
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, object.getName());
            statement.setString(2, object.getGender());
            statement.setString(3, object.getDate_of_birth());
            statement.setString(4, object.getId_card());
            statement.setString(5, object.getPhone_number());
            statement.setString(6, object.getEmail());
            statement.setString(7, object.getAddress());
            statement.setDouble(8, object.getSalary());
            statement.setLong(9, object.getPosition_id());
            statement.setLong(10, object.getDepartment_id());
            statement.setLong(11, object.getEducation_degree_id());
            statement.setLong(12, object.getUser_id());
            statement.setLong(13, object.getId());
            rowUpdate = statement.executeUpdate() > 0;
            return rowUpdate;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(Long id) {
        Connection connection = JDBCConnection.getConnection();
        boolean rowDeleted;
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1,id);
            rowDeleted = statement.executeUpdate() > 0;
            return rowDeleted;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
