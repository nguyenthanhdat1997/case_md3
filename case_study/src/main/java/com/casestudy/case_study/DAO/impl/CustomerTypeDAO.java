package com.casestudy.case_study.DAO.impl;

import com.casestudy.case_study.DAO.ICustomerTypeDAO;
import com.casestudy.case_study.model.CustomerType;
import com.casestudy.case_study.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeDAO implements ICustomerTypeDAO {
    private final String SELECT_ALL_CUSTOMERTYPE = "select * from customer_types where is_delete = 0";

    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> customerTypes = new ArrayList<>();

        Connection connection = JDBCConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMERTYPE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                customerTypes.add(new CustomerType(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypes;
    }

    @Override
    public CustomerType findById(Long id) {
        return null;
    }

    @Override
    public boolean save(CustomerType object) {
        return false;
    }

    @Override
    public boolean update(CustomerType object) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
