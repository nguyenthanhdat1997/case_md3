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
                Date date_of_birth = resultSet.getDate("date_of_birth");
                String id_card = resultSet.getString("id_card");
                String phone_number = resultSet.getString("id_card");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Long customer_type_id = resultSet.getLong("customer_type_id");
                Long user_id = resultSet.getLong("user_id");
                customers.add(new Customer(id, name, gender, date_of_birth, id_card, phone_number, email, address,customer_type_id,user_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public boolean save(Customer customer) {
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
