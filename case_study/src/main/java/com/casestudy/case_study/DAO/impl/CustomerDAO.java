package com.casestudy.case_study.DAO.impl;

import com.casestudy.case_study.DAO.ICustomerDAO;
import com.casestudy.case_study.model.Customer;
import com.casestudy.case_study.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    private final String SELECT_ALL_CUSTOMER = "select * from customers where is_delete = 0";
    private final String SELECT_BY_ID = "select * from customers where id = ?";
    private final String INSERT = "insert into customers(name,gender,date_of_birth,id_card,phone_number,email,address,customer_type_id,user_id) values(?,?,?,?,?,?,?,?,?); ";
    private final String DELETE = "update customers set is_delete = 1 where id = ?";
    private final String UPDATE = "update customers set name = ?, gender =?, date_of_birth = ?, id_card = ?, phone_number = ?, email = ?, address = ?, customer_type_id = ?, user_id = ? where id = ?";

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String date_of_birth = resultSet.getString("date_of_birth");
                String id_card = resultSet.getString("id_card");
                String phone_number = resultSet.getString("id_card");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Long customer_type_id = resultSet.getLong("customer_type_id");
                Long user_id = resultSet.getLong("user_id");
                customers.add(new Customer(id, name, gender, date_of_birth, id_card, phone_number, email, address, customer_type_id, user_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findById(Long id) {
        Customer customer = null;
        Connection connection = JDBCConnection.getConnection();
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
                Long customer_type_id = resultSet.getLong("customer_type_id");
                Long user_id = resultSet.getLong("user_id");
                customer = new Customer(name, gender, date_of_birth, id_card, phone_number, email, address, customer_type_id, user_id);
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Customer object) {
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
            statement.setLong(8, object.getCustomer_type_id());
            statement.setLong(9, object.getUser_id());

            int num = statement.executeUpdate();
            return num == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean update(Customer customer) {
        Connection connection = JDBCConnection.getConnection();
        boolean rowUpdated;
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getGender());
            statement.setString(3, customer.getDate_of_birth());
            statement.setString(4, customer.getId_card());
            statement.setString(5, customer.getPhone_number());
            statement.setString(6, customer.getEmail());
            statement.setString(7, customer.getAddress());
            statement.setLong(8, customer.getCustomer_type_id());
            statement.setLong(9, customer.getUser_id());
            statement.setLong(10, customer.getId());
            rowUpdated = statement.executeUpdate() > 0;
            return rowUpdated;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean remove(Long id) {
        Connection connection = JDBCConnection.getConnection();
        boolean customerDeleted;
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1,id);
            customerDeleted = statement.executeUpdate() > 0;
            return customerDeleted;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
