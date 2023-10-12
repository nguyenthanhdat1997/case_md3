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
    private static final String SELECT_ALL_BOOKING = "select * from bookings where is_delete = 0;";
    private static final String SELECT_BY_ID = "select * from bookings where id = ?";
    private static final String INSERT = "insert into bookings(book_time,status,customer_id,employee_id) values(?,?,?,?)";
    private static final String UPDATE_BOOKING = "update bookings set book_time = ?, status = ?, customer_id = ?, employee_id = ? where id = ?";
    private static final String DELETE_BOOKING = "update bookings set is_delete = 1 where id = ?";

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
            e.printStackTrace();
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
    public boolean add(Booking object) {
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
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Booking booking) {
        Connection connection = JDBCConnection.getConnection();
        boolean rowUpdated;
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKING);
            statement.setString(1, booking.getBook_time());
            statement.setString(2, booking.getStatus());
            statement.setLong(3, booking.getCustomer_id());
            statement.setLong(4, booking.getEmployee_id());
            statement.setLong(5, booking.getId());
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
        boolean bookingDeleted;

        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_BOOKING);
            statement.setLong(1, id);
            bookingDeleted = statement.executeUpdate() > 0;
            return bookingDeleted;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}