package com.casestudy.case_study.DAO.impl;

import com.casestudy.case_study.DAO.IBookingDAO;
import com.casestudy.case_study.model.Booking;
import com.casestudy.case_study.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO implements IBookingDAO {
    private final String SELECT_ALL_BOOKING = "select * from bookings";
    private static final String SELECT_BY_ID = "select * from bookings where id = ?";
    private final String INSERT = "insert into bookings(book_time,status,customer_id,employee_id) values(?,?,?,?)";
    private final String UPDATE_BOOKING = "update employees set book_time = ?, status = ?, customer_id = ?, employee = ? where id = ?";

    @Override
    public List<Booking> findAll() {
        List<Booking> bookings = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BOOKING);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String book_time = resultSet.getString("book_time");
                String status = resultSet.getString("status");
                Long customer_id = resultSet.getLong("customer_id");
                Long employee_id = resultSet.getLong("employee_id");
                bookings.add(new Booking(id, book_time, status, customer_id, employee_id));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookings;
    }

    @Override
    public Booking findById(Long id) {
        Booking booking = null;
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String book_time = resultSet.getString("book_time");
                String status = resultSet.getString("status");
                Long customer_id = resultSet.getLong("customer_id");
                Long employee_id = resultSet.getLong("employee_id");
                booking = new Booking(book_time, status, customer_id, employee_id);
                return booking;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Booking object) {
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1, object.getBook_time());
            statement.setString(2, object.getStatus());
            statement.setLong(3, object.getCustomer_id());
            statement.setLong(4, object.getEmployee_id());
            int num = statement.executeUpdate();

            return num == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Booking object) {
        Connection connection = JDBCConnection.getConnection();
        boolean rowUpdated;
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKING);
            statement.setString(1, object.getBook_time());
            statement.setString(2, object.getStatus());
            statement.setLong(3, object.getCustomer_id());
            statement.setLong(3, object.getEmployee_id());
            rowUpdated = statement.executeUpdate() > 0;
            return rowUpdated;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }

}